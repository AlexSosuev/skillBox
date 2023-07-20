public class Arithmetic {

    private int a;
    private int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Действия над числами " + a + " и " + b);
    }

    public int sumOfNumbers () {
        return a + b;
    }

    public int productOfNumbers () {
        return a * b;
    }

    public int maximumOfTwoNumbers () {
        return (a > b) ? a : b;
    }

    public int minimumOfTwoNumbers () {
        return (a < b) ? a : b;
    }
}
