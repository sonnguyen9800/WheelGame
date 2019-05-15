package client;

import model.SimplePlayer;
import model.SlotImpl;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.Player;

import static model.enumeration.Color.*;

public class TestHashCode {
    public static void main(String[] args) {



        for (BetType c : BetType.values()){
            System.out.println(c);
        }

        for (Color c : Color.values()){
            System.out.println(c);
        }

        SimplePlayer simplePlayer = new SimplePlayer("1","Adam", 0 );
        System.out.println(simplePlayer.toString());

        SlotImpl slot = new SlotImpl(0, GREEN00, 0);
        System.out.println(slot.toString());
    }
}
