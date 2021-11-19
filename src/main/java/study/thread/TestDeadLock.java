package study.thread;

import lombok.SneakyThrows;

/**
 * @author qinb
 * 死锁：多个线程互相抱着对方需要的资源不释放，形成僵持
 * @date 2021/9/16 15:47
 */
public class TestDeadLock {


    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0, "聂小倩");
        Makeup makeup2 = new Makeup(1, "张萌萌");
        makeup1.start();
        makeup2.start();
    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup extends Thread{
    //static为了保证只有一份资源
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeUp();
    }

    @SneakyThrows
    public void makeUp() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红资源");
                Thread.sleep(3000);
                //拥有了口红的锁的同时还想拥有镜子
//                synchronized (mirror) {
//                    System.out.println(this.girlName + "获得了镜子资源");
//                }
            }

            //将锁拿到外面
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子资源");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子资源");
                Thread.sleep(3000);
                //拥有了镜子的锁的同时还想拥有口红
//                synchronized (lipstick) {
//                    System.out.println(this.girlName + "获得了口红资源");
//                }
            }

            //将锁拿到外面
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红资源");
            }
        }
    }
}
