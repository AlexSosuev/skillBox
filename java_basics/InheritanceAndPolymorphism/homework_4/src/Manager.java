public class Manager implements Employee {
    private int companyRevenue = (int) (Math.random() * 25_000 + 115_000);
    private int baseSalary = (int) (Math.random() * 20_000 + 25_000);

    @Override
    public int getMonthSalary() {
        return baseSalary + (int) (companyRevenue * 0.05);
    }
}