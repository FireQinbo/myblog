package study.thread;

import sun.net.util.IPAddressUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinb
 * 测试线程池
 * @date 2021/9/22 14:45
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //1、创建线程池 大小为10
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭线程池
        service.shutdown();

    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
