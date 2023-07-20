package ru.skillbox;

public class Monitor {
    private final double diagonal;
    private final ScreenType screenType;
    private final double weight;

    public Monitor(double diagonal, ScreenType screenType, double weight) {
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "диагональ: " + diagonal + " дюймов" + "\n"
                + "тип экрана: " + screenType + "\n"
                + "вес: " + weight + " кг." + "\n";
    }
}
