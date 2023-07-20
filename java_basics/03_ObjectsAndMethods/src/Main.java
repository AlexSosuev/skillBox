public class Main {

    public static void main(String[] args) {
        Basket basketOne = new Basket();
        basketOne.add("Milk", 41);
        basketOne.print();

        Basket basketTwo = new Basket();
        basketTwo.add("Silver", 400, 3, 67);
        basketTwo.add("Gold", 4000, 2, 5);
        basketTwo.print();

        System.out.println(
                "Общая стоимость всех корзин: " + Basket.getTotalAllPrice() + " руб." + "\n"
                + "Общее количество товаров: " + Basket.getTotalAllCount() + " шт." + "\n"
                + "Средняя цена товара во всех корзинах: "
                        + String.format("%.2f", Basket.getAverageCostOfGoodOfBaskets()) + " руб." + "\n"
                + "Средняя стоимость корзины: "
                        + String.format("%.2f", Basket.getAverageCartValue()) + " руб." + "\n");
    }
}
