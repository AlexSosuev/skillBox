package practice;

public abstract class Client {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= amount && amountToTake > 0) {
            amount -= amountToTake;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "amount=" + amount +
                '}';
    }
}
