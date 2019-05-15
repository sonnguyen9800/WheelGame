package client;

import model.SlotImpl;
import model.enumeration.BetType;

import static model.enumeration.Color.Black;
import static model.enumeration.Color.Green0;

public class TestHashCode {
    public static void main(String[] args) {

        SlotImpl slot1 = new SlotImpl(1, 1, Black);
        System.out.println("HASH CODE "+ slot1.hashCode());

        SlotImpl slot2 = new SlotImpl(1,1, Green0);
        System.out.println("HASH CODE "+ slot2.hashCode());

        for (BetType c : BetType.values()){
            System.out.println(c);
        }
    }
}
