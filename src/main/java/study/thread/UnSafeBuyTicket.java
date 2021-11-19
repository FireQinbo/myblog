package study.thread;

import lombok.SneakyThrows;

/**
 * @author qinb
 * 线程不安全的买票
 * @date 2021/9/16 14:10
 */
public class UnSafeBuyTicket {


    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();


        new Thread(buyTicket, "张三").start();
        new Thread(buyTicket, "李四").start();
        new Thread(buyTicket, "王五").start();
    }
}


//多线程买票
class BuyTicket implements Runnable{
    //票数
    private Integer ticketNums = 10;
    private Boolean flag = true;  //外部停止线程标识


    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    //加上synchronized不同锁，实现线程安全
    @SneakyThrows
    private synchronized void buy() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟延时100毫秒
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
    }
}
