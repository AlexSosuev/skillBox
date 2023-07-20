package ru.skillbox;

public class CourierService {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean flip;
    private final String registrationNumber;
    private final boolean fragile;

    public CourierService(Dimensions dimensions, double weight, String deliveryAddress,
                          boolean flip, String registrationNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.flip = flip;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public CourierService setDimensions(Dimensions dimensions) {
        return new CourierService(dimensions, weight, deliveryAddress, flip, registrationNumber, fragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public CourierService setWeight(double weight) {
        return new CourierService(dimensions, weight, deliveryAddress, flip, registrationNumber, fragile);
    }

    public double getWeight() {
        return weight;
    }

    public CourierService setDeliveryAddress(String deliveryAddress) {
        return new CourierService(dimensions, weight, deliveryAddress, flip, registrationNumber, fragile);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isFlip() {
        return flip;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public String toString(){
        return "Масса: " + getWeight() + "\n" +
                "Адрес доставки: " + getDeliveryAddress() + "\n" +
                "Можно ли переворачивать: " + (isFlip()? "Да" : "Нет") + "\n" +
                "Регистрационный номер: " + getRegistrationNumber() + "\n" +
                "Является хрупким: " + (isFragile()? "Да" : "Нет") + "\n" + getDimensions();
    }
}
