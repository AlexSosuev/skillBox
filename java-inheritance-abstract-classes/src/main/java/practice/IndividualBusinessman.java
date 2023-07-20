package practice;

public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut * 0.99);
        } else {
            super.put(amountToPut * 0.995);
        }
    }

    @Override
    public String toString() {
        return "IndividualBusinessman{} " + super.toString();
    }
}
