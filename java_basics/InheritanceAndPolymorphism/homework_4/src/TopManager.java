import java.util.ArrayList;

public class TopManager implements Employee {
    private Company company = new Company(new ArrayList<>());
    private int baseSalary = (int) (Math.random() * 20_000 + 50_000);

    @Override
    public int getMonthSalary() {
        return (company.getIncome() > 10_000_000 ? (int) (2.5 * baseSalary) : baseSalary);
    }
}