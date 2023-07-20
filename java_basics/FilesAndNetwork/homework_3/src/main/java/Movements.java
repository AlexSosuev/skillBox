import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Movements {
    private double income = 0;
    private double expense = 0;
    private final Map<String, Double> expenseList = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Path.of(pathMovementsCsv));
            for (int i = 1; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", 8);
                double incomeTemp = getTemp(columns, 6);
                if (incomeTemp == 0) {
                    calculateExpense(columns[5], getTemp(columns,7));
                } else {
                    this.income += incomeTemp;
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private double getTemp(String[] columns, int i) {
        return Double.parseDouble(columns[i].replaceAll("\"", "").replace(',', '.'));
    }

    private void calculateExpense(String expenseName, double expense) {
        this.expense += expense;
        String[] transaction = expenseName.trim().split(" {3,}");
        String[] temp = transaction[1].split("/");
        String[] suppliesTemp = temp[temp.length - 1].split("\\\\");
        String supplies = suppliesTemp[suppliesTemp.length - 1];
        if (!expenseList.containsKey(supplies))
            expenseList.put(supplies, expense);
        else {
            double sum = expenseList.get(supplies);
            sum += expense;
            expenseList.put(supplies.trim(), sum);
        }
    }

    public double getExpenseSum() {
        return expense;
    }

    public double getIncomeSum() {
        return income;
    }

    public void printData() {
        System.out.println("ДВИЖЕНИЕ ДЕНЕЖНЫХ СРЕДСТВ");
        System.out.printf("Сумма расходов: %.2f руб\n", expense);
        System.out.printf("Сумма доходов: %.2f руб\n", income);
        System.out.println("--------------------------------------------------");
        System.out.println("СУММЫ РАСХОДОВ ПО ОРГАНИЗАЦИЯМ");
        for (String supplies : expenseList.keySet()) {
            System.out.printf("%-30s -----> %.2f %-10s\n", supplies, expenseList.get(supplies), "руб");
        }
    }
}