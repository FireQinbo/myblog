package study.thread;

/**
 * @author qinb
 * @date 2021/9/9 15:57
 */
public class TestThread5 implements Runnable{
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ("兔子".equals(Thread.currentThread().getName()) && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = this.gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    public static void main(String[] args) {
        TestThread5 t5 = new TestThread5();
        new Thread(t5, "兔子").start();
        new Thread(t5, "乌龟").start();
    }

    public boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if (steps == 99) {
            winner = Thread.currentThread().getName();
            System.out.println("winner = " + winner);

            return true;
        }

        return false;
    }


}
