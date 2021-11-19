package study.thread;

/**
 * @author qinb 测试守护线程（当用户线程结束后，守护线程也随着结束）
 * @date 2021/9/14 16:52
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        //设置成守护线程
        thread.setDaemon(true);
        thread.start();

        new Thread(new User()).start();
    }

}


class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("====上帝线程====");
        }
    }
}

class User implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("===人活了"+i+"年===");
        }
        System.out.println("===goodbye world！===");
    }
}
