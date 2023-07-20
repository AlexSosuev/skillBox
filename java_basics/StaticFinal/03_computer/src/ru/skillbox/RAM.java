package ru.skillbox;

public class RAM {
    private final String type;
    private final int volume;
    private final double weight;

    public RAM(String type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "тип памяти: " + type + "\n"
                + "объем памяти: " + volume + " Mb" + "\n"
                + "вес: " + weight + " кг." + "\n";
    }
}
