import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private Map<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void addAccountToBank(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        boolean check = false;
        if (isEnoughMoney(fromAccount.getMoney(), amount)) {
            long verificationLimit = 50000;
            if (amount > verificationLimit) {
                try {
                    check = isFraud(fromAccountNum, toAccountNum, amount);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                if (check) {
                    fromAccount.blockedAccount();
                    toAccount.blockedAccount();
                } else {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {
                            toAccount.setMoney(toAccount.getMoney() + amount);
                            fromAccount.setMoney(fromAccount.getMoney() - amount); }
                    }
                }
            } else {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        toAccount.setMoney(toAccount.getMoney() + amount);
                        fromAccount.setMoney(fromAccount.getMoney() - amount); }
                }
            }
        }
    }

    public boolean isEnoughMoney(long fromAccountMoney, long amount) {
        return fromAccountMoney >= amount;
    }

    public synchronized void getAccounts() {
        System.out.println(accounts.keySet());
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sumMoney = 0;
        for (Map.Entry<String, Account> item : accounts.entrySet()) {
            sumMoney += item.getValue().getMoney();
        }
        System.out.println("Общая сумма на всех счетах: " + sumMoney + " руб.");
        return sumMoney;
    }
}