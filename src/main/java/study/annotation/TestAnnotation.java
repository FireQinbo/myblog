package study.annotation;

import java.lang.annotation.*;

/**
 * @author qinb
 * @date 2021/9/30 16:13
 */
public class TestAnnotation {

    @MyAnnotation
    public void test() {

    }
}

//测试你如何定义一个注解
//Target 表示注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention 表示注解在什么地方有效（RUNTIME>CLASS>SOURCES）
@Retention(value = RetentionPolicy.RUNTIME)
//Documented 表示是否将注解生成到JAVAdoc中
@Documented
//Inherited 表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}
