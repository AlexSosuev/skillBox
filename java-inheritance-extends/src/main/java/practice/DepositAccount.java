package practice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount += amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    @Override
    public void take(double amountToTake) {
        if (amountToTake <= amount && amountToTake > 0
                && lastIncome.plus(1, ChronoUnit.MONTHS).isBefore(LocalDate.now())) {
            amount -= amountToTake;
        }
    }
}
