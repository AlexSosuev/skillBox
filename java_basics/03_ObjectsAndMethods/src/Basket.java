public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    private static double totalAllPrice = 0;
    private static int totalAllCount = 0;

    public static double getTotalAllPrice() {
        return totalAllPrice;
    }

    private static void increaseTotalAllPrice(int price, int count) {
        totalAllPrice += price * count;
    }

    public static int getTotalAllCount() {
        return totalAllCount;
    }

    private static void increaseTotalAllCount(int count) {
        totalAllCount += count;
    }

    public static  double getAverageCostOfGoodOfBaskets(){
        if (count != 0) {
            return totalAllPrice / totalAllCount;
        }
        else {
            return 0;
        }
    }

    public static double getAverageCartValue(){
        if (count != 0) {
            return totalAllPrice / count;
        }
        else {
            return 0;
        }
    }

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
        totalAllPrice += totalPrice;
        totalAllCount += count;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count += count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + count * price + " руб.";
        totalPrice += count * price;

        increaseTotalAllCount(count);
        increaseTotalAllPrice(price, count);
    }

    public void add(String name, int price, int count, double weight){
        add(name, price, count);
        totalWeight += weight * count;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(
                    count + "-я корзина: " + "\n"
                    + items + "\n"
                    +"Общая вес корзины: " + getTotalWeight() + " гр." + "\n"
                    + "Общая стоимость корзины: " + getTotalPrice() + " руб." + "\n");
        }
    }
}
