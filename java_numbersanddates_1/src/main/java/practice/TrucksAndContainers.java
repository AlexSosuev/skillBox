package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        int maxBoxes = 27;
        int maxContainer = 12;
        int numberTruck = 0;
        int numberContainer = 0;

        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        if (boxes > 0) {
            numberTruck = 1;
            numberContainer = 1;
            System.out.println("Грузовик: " + numberTruck);
            System.out.println("\tКонтейнер: " + numberContainer);

            for (int numberBoxes = 1; numberBoxes <= boxes; numberBoxes++) {
                System.out.println("\t\tЯщик: " + numberBoxes);

                if (numberBoxes % (maxBoxes * maxContainer) == 0){
                    numberTruck++;
                    System.out.println("Грузовик: " + numberTruck);
                }

                if (numberBoxes % maxBoxes == 0 && boxes > maxBoxes) {
                    numberContainer++;
                    System.out.println("\tКонтейнер: " + numberContainer);
                }
            }
        }

        System.out.println("Необходимо:" + "\n"
                + "грузовиков - " + numberTruck + " шт." + "\n"
                + "контейнеров - " + numberContainer + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
