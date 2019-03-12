package model;

import client.TestClient;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Logger;

public class GameEngineImpl implements GameEngine {

    private static final Logger logger = Logger.getLogger(TestClient.class.getName());


    private final static Integer POS_RANGE_LOW = 0;
    private final static Integer POS_RANGE_HIGH = 38;

    //Collection of Player:
    private ArrayList<Player> Players = new ArrayList<>();

    //Collection of GameEngineCallback
    private ArrayList<GameEngineCallback> GameEnginesCallBacks = new ArrayList<>();

    //Collection of Slots:
    private static ArrayList<Slot> SlotsCollection = iniSlotCollection();

    private static ArrayList<Slot> iniSlotCollection(){
        ArrayList<Slot> SlotsCo = new ArrayList<>();
        SlotsCo.add(new SlotImpl(0, 0, Color.Green00));
        int[] red = {27, 25, 12, 19, 18, 21, 16, 23, 14, 9, 30, 7, 32, 5, 34, 3, 36, 1};
        int[] black = {10, 29, 8, 31, 6, 33, 4, 35 , 2, 28, 26, 11, 20, 17, 22, 15, 24, 13};


        int num = 1;
        int redLeft = 0;
        int blackLeft = 0;

        while (num <= 37){
            Color color; int val;

            if (num == 19){
                color = Color.Green0;
                val = 0;
                SlotImpl slot = new SlotImpl(num, val, color);
                SlotsCo.add(slot);
                num++;
                continue; }

            if (num % 2 != 0){ color = Color.Red;val = red[redLeft];redLeft++;
            }else { color = Color.Black;val = black[blackLeft];blackLeft++; }

            SlotImpl slot = new SlotImpl(num, val, color);
            SlotsCo.add(slot);
            num++;
        }
        return SlotsCo;
    }



    // Random select a Slot from the Slot Collection
    private Slot randomlySelectASlot(ArrayList<Slot> slotsCollection){
        if (slotsCollection.isEmpty()){
            return null;
        }

        Random random = new Random();
        return slotsCollection.get(random.nextInt(slotsCollection.size()));
    }

    @Override
    public void spin(int initialDelay, int finalDelay, int delayIncrement) {
        int delay = initialDelay;
        Slot nextSlot = randomlySelectASlot(SlotsCollection);

//        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
//        this.addGameEngineCallback(gameEngineCallback);
        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
      //  this.addGameEngineCallback(gameEngineCallback);
        gameEngineCallback.nextSlot(nextSlot, this);

        while (delay < finalDelay){
            delay += delayIncrement;
            nextSlot = randomlySelectASlot(SlotsCollection);
            gameEngineCallback.nextSlot(nextSlot, this);
        }

        this.calculateResult(nextSlot);
        gameEngineCallback.result(nextSlot, this);

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
        iniSlotCollection();
        return SlotsCollection;
    }
}
