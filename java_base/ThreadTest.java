package java_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SayBaba implements Runnable {
    public int num = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("爸爸好" + "我是儿子" + ++num + "号");
    }

}

public class ThreadTest {
    public static void main(String[] args) {
        SayBaba sayBaba = new SayBaba();
        // Thread t1 = new Thread(sayBaba);
        // t1.start();
        // Thread t2 = new Thread(sayBaba);
        // t2.start();

        // 创建线程池
        ExecutorService exePool = Executors.newFixedThreadPool(2);
        exePool.execute(sayBaba);
        exePool.execute(sayBaba);
        exePool.shutdown();
    }
}