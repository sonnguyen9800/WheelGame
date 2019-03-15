package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {
    private String playerID;
    private String playerName;
    private int point;

    private BetType betType;

    private int bet;

    public SimplePlayer(String playerID, String playerName, int initialPoint) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.point = initialPoint;

        this.bet = 0;
        this.betType = BetType.GREEN0;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int getPoints() {
        return this.point;
    }

    @Override
    public void setPoints(int points) {
        this.point = points;
    }

    @Override
    public String getPlayerId() {
        return playerID;
    }

    @Override
    public boolean setBet(int bet) {
        if (bet > 0 && bet <= getPoints()){
            this.bet = bet;
            return true;
        }
        return false;
    }

    @Override
    public int getBet() {
        return this.bet;
    }

    @Override
    public void setBetType(BetType betType) {
        this.betType = betType;

    }

    @Override
    public BetType getBetType() {
        return this.betType;
    }

    @Override
    public void resetBet() {
        this.bet = 0;
    }

    @Override
    public String toString() {
        return "Data: player ID " + this.getPlayerId() + " Player Name: "
                + this.getPlayerName() + " Current Point "
                + this.getPoints() + " Bet Point: "
                + this.getBet() + " Type:"
                + this.getBetType();
    }
}
