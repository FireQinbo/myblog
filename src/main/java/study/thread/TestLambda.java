package study.thread;

/**
 * @author qinb Lambda表达式演变
 * @date 2021/9/14 15:06
 */
public class TestLambda {
    //2.静态内部类
    static class MyLove2 implements ILoveLambda{
        @Override
        public void loveLambda(int i) {
            System.out.println("i love lambda-->" + i);
        }
    }

    public static void main(String[] args) {
        ILoveLambda iLoveLambda = new MyLove();
        iLoveLambda.loveLambda(520);

        ILoveLambda iLoveLambda2 = new MyLove2();
        iLoveLambda2.loveLambda(521);

        //3.局部内部类
        class Mylove3 implements ILoveLambda {
            @Override
            public void loveLambda(int i) {
                System.out.println("i love lambda-->" + i);
            }
        }

        ILoveLambda iLoveLambda3 = new Mylove3();
        iLoveLambda3.loveLambda(522);

        //4.匿名内部类(没有类名，直接实现接口或者继承父类)
        ILoveLambda iLoveLambda4 = new ILoveLambda() {
            @Override
            public void loveLambda(int i) {
                System.out.println("i love lambda-->" + i);
            }
        };
        iLoveLambda4.loveLambda(523);

        //5.演变成Lambda表达式（只留下方法体）
        ILoveLambda iLoveLambda5 = (int i) -> {
            System.out.println("i love lambda-->" + i);
        };
        iLoveLambda5.loveLambda(524);

    }
}

//函数式接口（接口只有一个方法）
interface ILoveLambda{
    void loveLambda(int i);
}

//1.外部类
class MyLove implements ILoveLambda {
    @Override
    public void loveLambda(int i) {
        System.out.println("i love lambda-->" + i);
    }
}
