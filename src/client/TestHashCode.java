package client;

import model.SlotImpl;
import model.enumeration.Color;

public class TestHashCode {
    public static void main(String[] args) {

        SlotImpl slot1 = new SlotImpl(1, 1, Color.Black);
        System.out.println("HASH CODE "+ slot1.hashCode());

        SlotImpl slot2 = new SlotImpl(1,1,Color.Green0);
        System.out.println("HASH CODE "+ slot2.hashCode());
    }
}
