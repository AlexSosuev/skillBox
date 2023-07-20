package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(10, 20, 50);
        CourierService courierService = new CourierService(dimensions,
                    15,
                    "Сибирь-матушка",
                    false,
                    "1CV23",
                    true);

        CourierService copy = courierService.setDeliveryAddress("Moscow");
        copy = copy.setWeight(158);

        Dimensions dimensionsCopy = new Dimensions(100, 5, 34);
        copy = copy.setDimensions(dimensionsCopy);

        System.out.println("Исходный: " + "\n" + courierService);
        System.out.println("Измененный: " + "\n" + copy);

   }
}

