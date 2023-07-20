package ru.skillbox;

public class Dimensions {
    private final double width;
    private final double height;
    private final double length;

    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Dimensions setWidth(double width){
        return new Dimensions(width, height, length);
    }

    public double getWidth() {
        return width;
    }

    public Dimensions setHeight(double height){
        return new Dimensions(width, height, length);
    }

    public double getHeight() {
        return height;
    }

    public Dimensions setLength(double length){
        return new Dimensions(width, height, length);
    }

    public double getLength() {
        return length;
    }

    public double getVolume() {
        return width * height * length;
    }

    public String toString(){
        return "Ширина: " + width + "\n" +
                "Высота: " + height + "\n" +
                "Длина: " + length + "\n" +
                "Объем: " + getVolume();
    }
}
