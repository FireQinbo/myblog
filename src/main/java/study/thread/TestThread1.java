package study.thread;

/**
 * @author qinb
 * @date 2021/9/9 14:26
 */
public class TestThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我的线程i = " + i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        //开启线程
        testThread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("主线程i = " + i);
        }
    }
}
