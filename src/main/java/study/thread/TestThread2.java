package study.thread;


/**
 * @author qinb 继承Thread类方式
 * 多线程下载图片
 * @date 2021/9/9 14:44
 */
public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img2.baidu.com/it/u=3161564990,324578674&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1083","1.jpg");
        TestThread2 t2 = new TestThread2("https://img1.baidu.com/it/u=2210797393,3811366750&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1082","2.jpg");
        TestThread2 t3 = new TestThread2("https://img1.baidu.com/it/u=1960150800,410797218&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=961","3.jpg");

        //开启线程，他并不一定立即执行，由cpu调度
        t1.start();
        t2.start();
        t3.start();
    }
}
