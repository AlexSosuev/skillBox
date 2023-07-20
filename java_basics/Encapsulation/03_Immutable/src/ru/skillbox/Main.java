package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Хлеб ржаной", 41, "4607177744216");
        product.setPrice(43);
        System.out.println(product.getName() + " стоит " + product.getPrice() + " руб., имеет штрих-код - "
                + product.getBarCode());
    }
}
