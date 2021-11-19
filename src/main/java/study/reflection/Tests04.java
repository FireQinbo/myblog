package study.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author qinb
 * @date 2021/10/19 15:38
 */
public class Tests04 {
    //测试反射的性能，关闭权限安全检测之后的性能

    //正常方式
    public static void test1() {
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("正常方式10亿次执行时间：" + (endTime - startTime) + "ms");
    }

    //反射方式
    @SneakyThrows
    public static void test2() {
        User user = new User();
        Class aClass = user.getClass();
        Method getName = aClass.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方式10亿次执行时间：" + (endTime - startTime) + "ms");
    }

    //反射方式 关闭权限安全检测
    @SneakyThrows
    public static void test3() {
        User user = new User();
        Class aClass = user.getClass();
        Method getName = aClass.getDeclaredMethod("getName", null);
        //关闭检测
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测方式10亿次执行时间：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        //总结：
        //正常方式10亿次执行时间：7ms
        //反射方式10亿次执行时间：2794ms
        //关闭检测方式10亿次执行时间：1361ms
    }
}
