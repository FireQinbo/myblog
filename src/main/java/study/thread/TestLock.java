package study.thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qinb
 * 使用Lock同步锁
 * @date 2021/9/16 16:52
 */
public class TestLock {
    public static void main(String[] args) {

        BuyTicketForLock ticketForLock = new BuyTicketForLock();
        new Thread(ticketForLock,"1").start();
        new Thread(ticketForLock,"2").start();
        new Thread(ticketForLock,"3").start();
    }
}

class BuyTicketForLock implements Runnable {
    int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNums > 0) {
                    Thread.sleep(2000);
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
