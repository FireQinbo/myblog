package study.thread;

/**
 * @author qinb 实现Runnable接口的方式
 * @date 2021/9/9 15:11
 */
public class TestThread3 implements Runnable{
    private String url;
    private String name;

    public TestThread3(String url, String name) {
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
        TestThread3 t1 = new TestThread3("https://img2.baidu.com/it/u=3161564990,324578674&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1083", "1.jpg");
        TestThread3 t2 = new TestThread3("https://img1.baidu.com/it/u=2210797393,3811366750&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1082", "2.jpg");
        TestThread3 t3 = new TestThread3("https://img1.baidu.com/it/u=1960150800,410797218&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=961", "3.jpg");

        //启动线程的方式和继承Thread类有所不同，需要传入一个Runable接口的实现类
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}
