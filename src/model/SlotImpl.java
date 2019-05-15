package model;

import model.enumeration.Color;
import model.interfaces.Slot;

import java.util.Objects;

public class SlotImpl implements Slot {
    private int position;
    private int number;
    private Color color;

    public SlotImpl(int position,  Color color, int number) {
        this.position = position;
        this.number = number;
        this.color = color;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Slot slot) {
        return getColor().equals(slot.getColor())
                && getNumber() == slot.getNumber();
    }

    @Override
    public String toString() {
        return "Position: " + getPosition()
                + ", Color: " + getColor() +
                ", Number: " + getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Slot)) { return false; }
        Slot slot = (Slot)obj;
        return this.equals(slot);
    }


}
