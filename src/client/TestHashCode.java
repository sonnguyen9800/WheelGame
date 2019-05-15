package client;

import model.SlotImpl;
import model.enumeration.BetType;
import model.enumeration.Color;

import static model.enumeration.Color.BLACK;
import static model.enumeration.Color.GREEN0;

public class TestHashCode {
    public static void main(String[] args) {

        SlotImpl slot1 = new SlotImpl(1, 1, BLACK);
        System.out.println("HASH CODE "+ slot1.hashCode());

        SlotImpl slot2 = new SlotImpl(1,1, GREEN0);
        System.out.println("HASH CODE "+ slot2.hashCode());

        for (BetType c : BetType.values()){
            System.out.println(c);
        }

        for (Color c : Color.values()){
            System.out.println(c);
        }
    }
}
