package study.thread;

import lombok.SneakyThrows;

/**
 * @author qinb
 * 生产者 消费者案例测试
 * @date 2021/9/22 11:11
 */
public class TestProductConsumer {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        Productor productor = new Productor(synContainer);
        Consumer consumer = new Consumer(synContainer);

        productor.start();
        consumer.start();
    }

}

//生产者
class Productor extends Thread {
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了第->" + i + "只鸡");
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第" + synContainer.pop().id + "只鸡");
        }
    }
}

//产品
class Chicken{
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓存容器
class SynContainer {
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    @SneakyThrows
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
            //通知消费，生产者等待
            this.wait();
        }

        //如果没有满，就需要放入产品
        chickens[count] = chicken;
        count++;

        //可以通知消费了
        this.notifyAll();

    }

    //消费者消费
    @SneakyThrows
    public synchronized Chicken pop() {
        //判断能否消费
        if (count == 0) {
            //等待生产者，生产
            this.wait();
        }

        count--;
        Chicken chicken = chickens[count];

        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }

}



