package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU(3500, 4, "Intel", 0.05);
        RAM ram = new RAM("DDR3", 4096, 0.07);
        Storage storage = new Storage(DriveType.SSD, "4 Тб", 1);
        Monitor monitor = new Monitor(19.5, ScreenType.IPS, 4.5);
        Keyboard keyboard = new Keyboard("беспроводная", false, 0.728);

        Computer computer = new Computer(cpu, keyboard, monitor, ram, storage, "ASUS", "Gaming");
        System.out.println(computer.toString());
    }
}
