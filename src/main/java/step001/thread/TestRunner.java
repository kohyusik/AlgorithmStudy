package step001.thread;

public class TestRunner implements Runnable {

    int num;

    public TestRunner(int num) {
        this.num = num;
    }

    @Override
    public void run() {


        System.out.println(this.num+" thread start.");
        ThreadTestMain.conMap.put(String.valueOf(ThreadTestMain.no1++), this.num);
        ThreadTestMain.map.put(String.valueOf(ThreadTestMain.no2++), this.num);
        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }
        System.out.println(this.num+" thread end.");
    }
}