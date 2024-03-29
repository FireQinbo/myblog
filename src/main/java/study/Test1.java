package study;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA
 *
 * @author qinbo
 * @version 1.0.0 v
 * @date 2022-02-10 09:12
 * @description：测试练习1
 * @modified By：
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //master修改
        String a = "123";
        System.out.println("a = " + a);
        Test1.m1(a);
        System.out.println("a = " + a);

        int tenantId = 1;

        //master修改
        String str = "1";
        if ("1".equals(str)) {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("1", 123);
            System.out.println("map1 = " + map1);
            Test1.m2(map1);
            System.out.println("map1 = " + map1);
        }

        //master新增逻辑
    }

    public static void m1(String a) {
        a = "456";
    }

    public static void m2(Map<String, Integer> map1) {
//        map1.put("1", 456);
        map1 = new HashMap<>();
        map1.put("1", 456);
    }
}
