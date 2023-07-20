package ru.skillbox;

public class CPU {
    private final int frequency;
    private final int numberOfCores;
    private final String manufacturer;
    private final double weight;

    public CPU(int frequency, int numberOfCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "частота: " + frequency + " GHz" + "\n"
                + "количество ядер: " + numberOfCores + "\n"
                + "производитель: " + manufacturer + "\n"
                + "вес: " + weight + " кг." + "\n";
    }
}
