import redis.clients.jedis.Jedis;

import java.util.Date;

public class MeetingSite {

    private Jedis jedis;
    private final String KEY = "Users";

    public void init() {
        jedis = new Jedis("localhost", 6379);
    }

    public void deleteAll() {
        jedis.flushDB();
    }

    public void addUser(int user) {
        jedis.zadd(KEY, getTs(), String.valueOf(user));
    }

    public void showAll() {
        System.out.println(jedis.zrange(KEY, 0, -1));
    }

    private double getTs() {
        return (double) (new Date().getTime() / 1000);
    }
}