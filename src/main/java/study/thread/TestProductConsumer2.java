package study.thread;

import lombok.SneakyThrows;

/**
 * @author qinb
 * 测试生产者 消费者 案例2
 * @date 2021/9/22 14:20
 */
public class TestProductConsumer2 {

    public static void main(String[] args) {
        Tv tv = new Tv();
        new player(tv).start();
        new watcher(tv).start();
    }
}

//生产者-》演员
class player extends Thread {
    Tv tv;

    public player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("快乐大本营！");
            } else {
                this.tv.play("抖音：记录美好生活!");
            }
        }
    }
}


//消费者-》观众
class watcher extends Thread {
    Tv tv;

    public watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}


//产品-》节目
class Tv {
    //要表演的节目
    String voice;

    //标志位
    Boolean flag = true;

    //表演
    @SneakyThrows
    public synchronized void play(String voice) {
        if (!flag) {
            this.wait();
        }

        System.out.println("演员表演了：" + voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    @SneakyThrows
    public synchronized void watch() {
        if (flag) {
            this.wait();
        }

        System.out.println("观众观看了：" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}
