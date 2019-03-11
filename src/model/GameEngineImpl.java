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
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEngineImpl implements GameEngine {

    private static final Logger logger = Logger.getLogger(TestClient.class.getName());


    private final static Integer POS_RANGE_LOW = 1;
    private final static Integer POS_RANGE_HIGH = 36;

    //Collection of Player:
    private ArrayList<Player> Players = new ArrayList<>();

    //Collection of GameEngineCallback
    private ArrayList<GameEngineCallback> GameEnginesCallBacks = new ArrayList<>();

    //Collection of Slots:
    private ArrayList<Slot> SlotsCollection = new ArrayList<>();

    private void iniSlotCollection(){
        SlotsCollection.add(new SlotImpl(0, 0, Color.GREEN0));

        for (int i = POS_RANGE_LOW; i <= POS_RANGE_HIGH; i++){

            Color color;
            if (i % 2 == 0){
                color = Color.BLACK;
            }else{
                color = Color.RED;
            }

            SlotImpl slot = new SlotImpl(i, i, color);
            SlotsCollection.add(slot);

        }
        SlotsCollection.add(new SlotImpl(POS_RANGE_HIGH + 1, POS_RANGE_HIGH + 1, Color.GREEN00));

    }
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
        Slot firstSlot = randomlySelectASlot(SlotsCollection);

        GameEngineCallbackImpl gameEngineCallback = new GameEngineCallbackImpl();
        this.addGameEngineCallback(gameEngineCallback);

        gameEngineCallback.nextSlot(firstSlot, this);
        Slot nextSlot = firstSlot;

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
