package practice;

public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }

    @Override
    public String toString() {
        return "LegalPerson{} " + super.toString();
    }
}
