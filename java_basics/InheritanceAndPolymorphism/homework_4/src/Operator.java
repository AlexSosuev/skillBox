public class Operator implements Employee {
    private int baseSalary = (int) (Math.random() * 20_000 + 15_000);

    @Override
    public int getMonthSalary() {
        return baseSalary;
    }
}