package step001.kko;

import step001.thread.TestRunner;

import java.util.concurrent.ConcurrentHashMap;

public class Test32 {


    public static void main(String[] args) {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();


        for (int i = 0; i < 10; i++) {

            Thread t1 = new Thread(new TestRunner(i));

            t1.start();
        }






    }



}