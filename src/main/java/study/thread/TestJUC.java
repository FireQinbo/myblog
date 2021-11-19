package study.thread;

import lombok.SneakyThrows;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qinb
 * @date 2021/9/16 15:39
 */
public class TestJUC {
    @SneakyThrows
    public static void main(String[] args) {
        //线程安全的list集合
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(list.size());

    }
}
