package study.thread;

/**
 * 人间四大喜事：
 * 久旱逢甘霖
 * 他乡遇故知
 * 洞房花烛夜
 * 金榜题名时
 * @author qinb 重现线程的静态代理模式
 * @date 2021/9/14 11:00
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        new WeddingCompamy(new I()).happyMarry();
        //对比线程的调用
        new Thread(()->{
            System.out.println("线程调用");
        }).start();
    }

}

//结婚接口
interface Marry{
    void happyMarry();
}

//我实现结婚
class I implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("我结婚...");
    }
}

//婚庆公司也实现结婚接口，代理我（布置现场等...）
class WeddingCompamy implements Marry {

    private I i;

    public WeddingCompamy(I i){
        this.i = i;
    }

    @Override
    public void happyMarry() {
        //婚庆公司，婚前布置现场
        before();
        //实际还是调用的我结婚
        i.happyMarry();
        //婚庆公司婚后，收尾款
        after();
    }

    public void before() {
        System.out.println("开始布置现场...");
    }

    public void after() {
        System.out.println("收尾款...");
    }
}
