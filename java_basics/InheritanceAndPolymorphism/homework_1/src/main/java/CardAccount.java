public class CardAccount extends BankAccount {
    private final double comission = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * (1 + comission));
    }
}
