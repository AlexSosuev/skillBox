package ru.skillbox;

public class Computer {
    private CPU cpu;
    private Keyboard keyboard;
    private Monitor monitor;
    private RAM ram;
    private Storage storage;
    private final String vendor;
    private final String name;

    public Computer(CPU cpu, Keyboard keyboard, Monitor monitor, RAM ram, Storage storage, String vendor, String name) {
        this.cpu = cpu;
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.ram = ram;
        this.storage = storage;
        this.vendor = vendor;
        this.name = name;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public double getTotalWeight() {
        return cpu.getWeight() + monitor.getWeight() + ram.getWeight() + storage.getWeight() + keyboard.getweight();
    }

    public String toString(){
        return "Название - " + name + "\n" + "производитель: " + vendor + "\n"
                + "Общий вес компьютера: " + getTotalWeight() + " кг." + "\n"
                + "Характеристики компьютера: " + "\n" + "\n"
                + "Процессор: " + cpu.toString() + "\n"
                + "Оперативная память: " + ram.toString() + "\n"
                + "Накопитель информации: " + storage.toString() + "\n"
                + "Экран: " + monitor.toString() + "\n"
                + "Клавиатура: " + keyboard.toString();
    }
}
