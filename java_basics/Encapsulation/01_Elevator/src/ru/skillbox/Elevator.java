package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor () {
        return currentFloor;
    }

    public void moveDown () {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp () {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Такого этажа не существует!!!");
        }
        else if (floor == currentFloor) {
            System.out.println("Как хорошо, что не нужно никуда ехать. Я так боюсь лифтов)))");
        }
        else {
            System.out.println("Вы хотите попасть на " + floor
                    + " этаж. Сейчас Вы находитесь на " + currentFloor + " этаже.");
            if (floor > currentFloor){
                System.out.println("Поехали вверх");
                while (floor > currentFloor){
                    moveUp();
                    System.out.println("Текущий этаж " + currentFloor);
                }
            }
            else {
                System.out.println("Поехали вниз");
                while (floor < currentFloor){
                    moveDown();
                    System.out.println("Текущий этаж " + currentFloor);
                }
            }
        }
    }

}
