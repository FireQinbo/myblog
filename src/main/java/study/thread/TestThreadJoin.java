package study.thread;

/**
 * @author qinb 测试线程插队，插队线程先执行，其他线程阻塞，等待其执行完，再执行
 * @date 2021/9/14 16:21
 */
public class TestThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("VIP线程 = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadJoin testThreadJoin = new TestThreadJoin();
        Thread t = new Thread(testThreadJoin);
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程：" + i);
            if (i == 50) {
                //vip线程插队
                t.join();
            }
        }
    }
}
