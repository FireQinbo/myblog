package study.thread;

import java.util.concurrent.*;

/**
 * @author qinb  实现callable接口的方式
 * @date 2021/9/9 16:56
 */
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("name = " + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img2.baidu.com/it/u=3161564990,324578674&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1083", "1.jpg");
        TestCallable t2 = new TestCallable("https://img1.baidu.com/it/u=2210797393,3811366750&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1082", "2.jpg");
        TestCallable t3 = new TestCallable("https://img1.baidu.com/it/u=1960150800,410797218&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=961", "3.jpg");

        //创建执行任务服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println("rs1 = " + rs1);

        //关闭服务
        service.shutdownNow();
    }
}
