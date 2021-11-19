package study.thread;

/**
 * @author qinb 测试线程停止
 * @date 2021/9/14 15:42
 */
public class TestThreadStop implements Runnable {
    //设置标识符，用来停止线程
    private Boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("线程：" + Thread.currentThread().getName() + "执行中..." + i++);
        }
    }

    //手动创建一个停止线程的标识方法
    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestThreadStop t = new TestThreadStop();
        new Thread(t, "测试线程1").start();

        //在主线程中停止线程
        for (int i = 0; i < 500; i++) {
            System.out.println("主线程i = " + i);
            if (i == 250) {
                System.out.println("停止点 " + i);
                t.stop();
            }
        }
    }
}
