package step001.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadTestMain {


    public static ConcurrentHashMap<String, Object> conMap = new ConcurrentHashMap<>();
    public static Map<String, Object> map = new HashMap<>();

    public static int no1 = 0;
    public static int no2 = 0;


    public static void main(String[] args) {



        for (int i = 0; i < 10; i++) {

            Thread t1 = new Thread(new TestRunner(i));

            t1.start();

        }


        System.out.println(no1);
        System.out.println(conMap);


        System.out.println(no2);
        System.out.println(map);





    }



}