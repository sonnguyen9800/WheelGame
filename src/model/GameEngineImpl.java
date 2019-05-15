package model;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameEngineImpl implements GameEngine {

    //Collection of Player:
    private Collection<Player> Players = new ArrayList<>();

    //Collection of GameEngineCallback
    private Collection<GameEngineCallback> GameEnginesCallBacks = new ArrayList<>();

    //Collection of Slots:
    private static List<Slot> SlotsCollection = iniSlotCollection();
    private static List<Slot> iniSlotCollection(){
        List<Slot> SlotsCo = new ArrayList<>();
        SlotsCo.add(new SlotImpl(0, Color.GREEN00,0));
        int[] red = {27, 25, 12, 19, 18, 21, 16, 23, 14, 9, 30, 7, 32, 5, 34, 3, 36, 1};
        int[] black = {10, 29, 8, 31, 6, 33, 4, 35 , 2, 28, 26, 11, 20, 17, 22, 15, 24, 13};


        int num = 1;
        int redLeft = 0;
        int blackLeft = 0;

        while (num <= 37){
            Color color; int val;

            if (num == 19){
                color = Color.GREEN0;
                val = 0;
                SlotImpl slot = new SlotImpl(num,  color, val);
                SlotsCo.add(slot);
                num++;
                continue; }

            if (num % 2 != 0){ color = Color.RED;val = red[redLeft];redLeft++;
            }else { color = Color.BLACK;val = black[blackLeft];blackLeft++; }

            SlotImpl slot = new SlotImpl(num, color, val);
            SlotsCo.add(slot);
            num++;
        }
        return SlotsCo;
    }


    // Random select a Slot from the Slot Collection
    private Slot randomlySelectASlot(List<Slot> slotsCollection){
        if (slotsCollection.isEmpty()){
            return null;
        }

        Random random = new Random();
        return slotsCollection.get(random.nextInt(slotsCollection.size()));
    }
    private Slot moveToNextSlot(Slot currentSlot, List<Slot> slotsCollection){
        int index = 0;
        for (int i = 0; i < slotsCollection.size(); i++){
            if (slotsCollection.get(i).equals(currentSlot)){
                index = i;
                break;
            }
        }

        if (index == slotsCollection.size() - 1){
            return slotsCollection.get(0);
        }else{
            return slotsCollection.get(index+1);
        }
    }

    @Override
    public void spin(int initialDelay, int finalDelay, int delayIncrement) {
        Slot nextSlot = randomlySelectASlot(SlotsCollection);

        while (initialDelay < (finalDelay-delayIncrement)){
            try {
                Thread.sleep((long)initialDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            initialDelay += delayIncrement;
            nextSlot = moveToNextSlot(nextSlot, SlotsCollection);

            for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks){
                gameEngineCallback.nextSlot(nextSlot, this);
            }

        }
        Slot lastSlot = moveToNextSlot(nextSlot, SlotsCollection);
        this.calculateResult(lastSlot);
        for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks){
            gameEngineCallback.result(lastSlot, this);
        }

    }

    @Override
    public void calculateResult(Slot winningSlot) {
        for (Player player : Players){
            player.getBetType().applyWinLoss(player, winningSlot);
        }
    }

    @Override
    public void addPlayer(Player player) {
        if (player == null){return; }

        //Check and find the player which has the same id as the parameter player

        for (Player player_i : Players){
            if (player_i.getPlayerId().equals(player.getPlayerId())){
                Players.remove(player_i);
                Players.add(player);
                return;
            }
        }

        Players.add(player);

    }

    @Override
    public Player getPlayer(String id) {
        for (Player player : Players){
            if (player.getPlayerId().equals(id)){
                return player;
            }
        }
        return null;
    }

    @Override
    public boolean removePlayer(Player player) {
        if (Players.contains(player)){
            Players.remove(player);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
        if (gameEngineCallback == null){return;}
        GameEnginesCallBacks.add(gameEngineCallback);
    }

    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
        if (GameEnginesCallBacks.contains(gameEngineCallback)){
            GameEnginesCallBacks.remove(gameEngineCallback);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Player> getAllPlayers() {
        return Players;
    }

    @Override
    public boolean placeBet(Player player, int bet, BetType betType) {

        if (bet > 0 && bet <= player.getPoints()){
            player.setBetType(betType);
            player.setBet(bet);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Slot> getWheelSlots() {
        return SlotsCollection;
    }
}
