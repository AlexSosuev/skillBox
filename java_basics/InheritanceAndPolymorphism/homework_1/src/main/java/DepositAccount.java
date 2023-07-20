import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }


    @Override
    public void take(double amountToTake) {
        if (lastIncome.plus(1, ChronoUnit.MONTHS).isBefore(LocalDate.now())) {
            super.take(amountToTake);
        }
    }
}