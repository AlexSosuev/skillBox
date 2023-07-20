package ru.skillbox;

public class Keyboard {
    private final String type;
    private final boolean thePresenceOfBacklight;
    private final double weight;

    public Keyboard(String type, boolean thePresenceOfBacklight, double weight) {
        this.type = type;
        this.thePresenceOfBacklight = thePresenceOfBacklight;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public boolean getThePresenceOfBacklight() {
        return thePresenceOfBacklight;
    }

    public double getweight() {
        return weight;
    }

    public String toString(){
        return "тип : " + type + "\n"
                + "наличие подсветки: " + thePresenceOfBacklight + "\n"
                + "вес: " + weight + " кг.";
    }
}
