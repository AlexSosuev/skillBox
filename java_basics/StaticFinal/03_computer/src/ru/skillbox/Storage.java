package ru.skillbox;

public class Storage {
    private final DriveType driveType;
    private final String memory;
    private final double weight;

    public Storage(DriveType driveType, String memory, double weight) {
        this.driveType = driveType;
        this.memory = memory;
        this.weight = weight;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public String getMemory() {
        return memory;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "тип накопителя: " + driveType + "\n"
                + "объем памяти: " + memory + "\n"
                + "вес: " + weight + " кг." + "\n";
    }
}
