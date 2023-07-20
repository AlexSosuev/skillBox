public class Main {
    private static final int USERS = 20;
    private static int major;
    private static final MeetingSite jedis = new MeetingSite();

    public static void main(String[] args) throws InterruptedException {
        jedis.init();
        while (true) {
            for (int i = 1; i <= USERS; i++) {
                if (i % 10 == 0) {
                    major = (int) (Math.random() * (USERS - 1) + 1);
                    System.out.println("Пользователь " + major + " оплатил платную услугу");
                    log(major);
                }
                if (major == i) {
                    continue;
                }
                log(i);
            }
        }
    }

    private static void log(int user) throws InterruptedException {
        jedis.addUser(user);
        System.out.println("На главной странице показываем пользователя " + user);
        Thread.sleep(1000);
    }
}