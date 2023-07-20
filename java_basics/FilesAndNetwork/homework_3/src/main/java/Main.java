public class Main {
    private static final String MOVEMENTS_LIST = "src/test/resources/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(MOVEMENTS_LIST);
        movements.printData();
    }
}