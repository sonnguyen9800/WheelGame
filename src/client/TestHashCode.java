package client;

import model.SlotImpl;
import model.enumeration.BetType;
import model.enumeration.Color;

import static model.enumeration.Color.BLACK;
import static model.enumeration.Color.GREEN0;

public class TestHashCode {
    public static void main(String[] args) {



        for (BetType c : BetType.values()){
            System.out.println(c);
        }

        for (Color c : Color.values()){
            System.out.println(c);
        }
    }
}
