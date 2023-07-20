package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator action = new ArithmeticCalculator(48, 2);
        System.out.println("Результат операции: " + action.calculation(Operation.ADD));
    }
}
