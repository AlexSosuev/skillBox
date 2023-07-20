package practice;

public class CardAccount extends BankAccount {
    private final double comission = 0.01;

    @Override
    public void take(double amountToTake) {
        if (amountToTake * (1 + comission) <= amount && amountToTake > 0) {
            amount -= (amountToTake * (1 + comission));
        }
    }
}
