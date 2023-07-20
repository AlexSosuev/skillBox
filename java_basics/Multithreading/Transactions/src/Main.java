public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account firstClient = new Account("00001111", 100_000);
        Account secondClient = new Account("00002222", 100_000);

        bank.addAccountToBank(firstClient);
        bank.addAccountToBank(secondClient);

        Thread threadOne = new Thread(() -> {
            bank.transfer(firstClient.getAccNumber(), secondClient.getAccNumber(), 250);
            bank.transfer(secondClient.getAccNumber(), firstClient.getAccNumber(), 250);
            bank.getBalance(firstClient.getAccNumber());
            bank.getBalance(secondClient.getAccNumber());
            System.out.println(Thread.currentThread().getName());
        });

        Thread threadTwo = new Thread(() -> {
            bank.transfer(secondClient.getAccNumber(), firstClient.getAccNumber(), 250);
            bank.transfer(firstClient.getAccNumber(), secondClient.getAccNumber(), 250);
            bank.getBalance(firstClient.getAccNumber());
            bank.getBalance(secondClient.getAccNumber());
            System.out.println(Thread.currentThread().getName());
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }
}