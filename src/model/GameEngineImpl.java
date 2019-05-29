package model;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.GameEngineCallbackGUI;
import view.interfaces.GameEngineCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameEngineImpl implements GameEngine {
    //Collection of Slots:
    private static List<Slot> SlotsCollection = iniSlotCollection();
    //Collection of Player:
    private ArrayList<Player> Players = new ArrayList<>();
    //Collection of GameEngineCallback
    private Collection<GameEngineCallback> GameEnginesCallBacks;

    public GameEngineImpl() {
        GameEnginesCallBacks = new ArrayList<>();
    }

    private static List<Slot> iniSlotCollection() {
        List<Slot> SlotsCo = new ArrayList<>();
        SlotsCo.add(new SlotImpl(0, Color.GREEN00, 0));
        int[] red = {27, 25, 12, 19, 18, 21, 16, 23, 14, 9, 30, 7, 32, 5, 34, 3, 36, 1};
        int[] black = {10, 29, 8, 31, 6, 33, 4, 35, 2, 28, 26, 11, 20, 17, 22, 15, 24, 13};
        int num = 1;
        int redLeft = 0;
        int blackLeft = 0;

        while (num <= 37) {
            Color color;
            int val;

            if (num == 19) {
                color = Color.GREEN0;
                val = 0;
                SlotImpl slot = new SlotImpl(num, color, val);
                SlotsCo.add(slot);
                num++;
                continue;
            }

            if (num % 2 != 0) {
                color = Color.RED;
                val = red[redLeft];
                redLeft++;
            } else {
                color = Color.BLACK;
                val = black[blackLeft];
                blackLeft++;
            }

            SlotImpl slot = new SlotImpl(num, color, val);
            SlotsCo.add(slot);
            num++;
        }
        return SlotsCo;
    }


    // Random select a Slot from the Slot Collection
    private Slot randomlySelectASlot(List<Slot> slotsCollection) {
        if (slotsCollection.isEmpty()) {
            return null;
        }

        Random random = new Random();
        return slotsCollection.get(random.nextInt(slotsCollection.size()));
    }

    private Slot moveToNextSlot(Slot currentSlot, List<Slot> slotsCollection) {
        int index = 0;
        for (int i = 0; i < slotsCollection.size(); i++) {
            if (slotsCollection.get(i).equals(currentSlot)) {
                index = i;
                break;
            }
        }

        if (index == slotsCollection.size() - 1) {
            return slotsCollection.get(0);
        } else {
            return slotsCollection.get(index + 1);
        }
    }

    @Override
    public void spin(int initialDelay, int finalDelay, int delayIncrement) {
        boolean GUIexist = false;


        GameEngineImpl gameEngineRef = this;
        Slot firstSlot = randomlySelectASlot(SlotsCollection);
        for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks) {
            gameEngineCallback.nextSlot(firstSlot, this);
            if (gameEngineCallback instanceof GameEngineCallbackGUI){
                GUIexist = true;
            }
        }
        if (GUIexist){
            Timer timer = new Timer(initialDelay, null);
            timer.addActionListener(new ActionListener() {
                Slot nextSlot = firstSlot;
                int delay = initialDelay;
                GameEngineImpl gameEngine = gameEngineRef;
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (delay < (finalDelay-delayIncrement)){
                        nextSlot = moveToNextSlot(nextSlot, SlotsCollection);
                        for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks) {
                            gameEngineCallback.nextSlot(nextSlot, gameEngine );
                        }
                        timer.setDelay(delay += delayIncrement);
                    } else{
                        nextSlot = moveToNextSlot(nextSlot, SlotsCollection);

                        gameEngine.calculateResult(nextSlot);
                        for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks) {
                            gameEngineCallback.result(nextSlot, gameEngine );
                        }
                        for (Player player: getAllPlayers()){
                            player.resetBet();
                        }
                        timer.stop();
                    }

                }
            });
            timer.start();
        }

        if (!GUIexist){
            //int delay = initialDelay;
            Slot nextSlot = firstSlot;

            for (int delay = initialDelay; delay <= finalDelay; delay+= delayIncrement ){
                nextSlot = moveToNextSlot(nextSlot, SlotsCollection);

                delay += delayIncrement;
                if (delay < (finalDelay - delayIncrement)){
                    for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks){
                        gameEngineCallback.nextSlot(nextSlot, this);
                    }
                }else{
                    this.calculateResult(nextSlot);
                    for (GameEngineCallback gameEngineCallback : GameEnginesCallBacks){
                        gameEngineCallback.result(nextSlot, this);
                    }
                }
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }



    }

    @Override
    public void calculateResult(Slot winningSlot) {
        for (Player player : Players) {
            player.getBetType().applyWinLoss(player, winningSlot);
        }
    }

    @Override
    public void addPlayer(Player player) {
        if (player == null) {
            return;
        }

        //Check and find the player which has the same id as the parameter player

        for (Player player_i : Players) {
            if (player_i.getPlayerId().equals(player.getPlayerId())) {
                Players.remove(player_i);
                Players.add(player);
                return;
            }
        }

        Players.add(player);

    }

    @Override
    public Player getPlayer(String id) {
        for (Player player : Players) {
            if (player.getPlayerId().equals(id)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public boolean removePlayer(Player player) {
        if (Players.contains(player)) {
            Players.remove(player);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
        if (gameEngineCallback == null) {
            return;
        }
        GameEnginesCallBacks.add(gameEngineCallback);
    }

    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
        if (GameEnginesCallBacks.contains(gameEngineCallback)) {
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

        if (bet > 0 && bet <= player.getPoints()) {
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
