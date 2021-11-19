package study.thread;

/**
 * @author qinb
 * @date 2021/9/9 15:43
 */
public class TestThread4 implements Runnable{
    //票数量
    private int ticketNum = 10;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "---->拿到了第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4, "小明").start();
        new Thread(testThread4, "老师").start();
        new Thread(testThread4, "黄牛党").start();
    }
}
