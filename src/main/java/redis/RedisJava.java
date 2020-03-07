package redis;

import org.w3c.dom.ls.LSOutput;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

public class RedisJava {
    public static void main(String[] args) throws InterruptedException{
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        System.out.println("Server is running: "+jedis.ping());

        // ----------------------------------------------------------------------------

        jedis.set("Name ", "Yashwanth");
        jedis.append("Name ", " Alagappan");

        System.out.println("Appended Name is : Name = " + jedis.get("Name "));

        // ----------------------------------------------------------------------------

        Set<String> setKeys = jedis.keys("set*");
        System.out.println("Set keys alone : ");
        setKeys.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ----------------------------------------------------------------------------

        Set<String> allKeys = jedis.keys("*");
        System.out.print("All keys : ");
        allKeys.forEach(x -> System.out.print(x + "|"));
        System.out.println();
        System.out.print("All types: ");
        allKeys.forEach(x -> System.out.print(jedis.type(x) + "|"));
        System.out.println();

        // ----------------------------------------------------------------------------

        jedis.set("x", "9");
        jedis.incr("x");
        System.out.println("Increment " + jedis.get("x"));

        jedis.incrBy("x", 5);
        System.out.println("Increment by 5 " + jedis.get("x"));

        jedis.incrByFloat("x", 0.5);
        System.out.println("Increment by 0.5 " + jedis.get("x"));

        // ----------------------------------------------------------------------------

        String result = (jedis.del("x") == 1)? "Success" : "failed to delete";
        System.out.println(result);
        System.out.println(jedis.get("x"));

        System.out.println("Key \"x\" exists ? " + jedis.exists("x"));

        // ----------------------------------------------------------------------------

        /*jedis.set("y", "Y");
        jedis.expire("y", 3);
        System.out.println("Key \"y\" exists ? " + jedis.exists("y"));

        System.out.println("Sleeping main thread.... for 3 seconds");
        Thread.sleep(3000);

        System.out.println("Key \"y\" exists after 3 seconds? " + jedis.exists("y"));

        // ----------------------------------------------------------------------------
        jedis.set("z", "Z");
        jedis.expire("z", 3);
        jedis.persist("z");
        System.out.println("Persisting z.. Sleeping for 4 seconds");
        Thread.sleep(4000);
        System.out.println("Key \"z\" exists after persist() ? " + jedis.exists("z"));*/

        // ----------------------------------------------------------------------------

        System.out.println("get substring 0 to 10");
        System.out.println(jedis.getrange("fname", 0, 8));

        System.out.println("get substring 0 to -1 (full)");
        System.out.println(jedis.getrange("fname", 0, -1));

        // ----------------------------------------------------------------------------

        jedis.set("mandir", "ram");
        jedis.get("mandir");
        jedis.setrange("mandir", 0, "RAM");
        System.out.println("Replaced ram using setrange() to : " + jedis.get("mandir"));

        // ----------------------------------------------------------------------------

        jedis.mset("vishnu", "thirupavai", "shiva","thiruvembavai");
        System.out.println("MSET: " + jedis.get("vishnu") + " " + jedis.get("shiva"));

        // ----------------------------------------------------------------------------

        Map<String, String> map = new HashMap<>();
        map.put("One", "1");
        map.put("Two", "2");
        map.put("Three", "3");
        jedis.hmset("HashByJava", map);
        System.out.println(jedis.hgetAll("HashByJava"));
        if(jedis.hexists("HashByJava","Three")){
            System.out.println("hexists true");
            System.out.println("hget : " + jedis.hget("HashByJava","Three"));
        }

        System.out.println("hkeys : " + jedis.hkeys("HashByJava"));

        Map<String, String> map1 = new HashMap<>();
        map1.put("One", "Ek");
        map1.put("Four", "chaar");
        jedis.hset("HashByJava", map1);
        System.out.println(jedis.hgetAll("HashByJava"));

        System.out.println("All values hvals : " + jedis.hvals("HashByJava"));

        // No expiry method specific for hash. Using existing jedis.expire(key, time)

        jedis.expire("HashByJava", 10);
        jedis.persist("HashByJava");
    }
}