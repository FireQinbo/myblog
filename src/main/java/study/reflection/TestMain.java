package study.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qinb
 * @date 2021/10/19 13:47
 */
public class TestMain {
    @SneakyThrows
    public static void main(String[] args) {
        Test03Son test03Son = new Test03Son();
        Class<? extends Test03Son> test03SonClass = test03Son.getClass();

        //getFields：获取子类以及父类公共修饰符的属性
        Field[] fields = test03SonClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName());
        }

        //getDeclaredFields：获取本类所有的定义的属性，不受修饰符限制
        Field[] declaredFields = test03SonClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField.getName());
        }


        //getMethods:获取子类以及父类公共修饰符的方法，包括Object类的
        Method[] methods = test03SonClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }

        //getDeclaredMethods:获取本类的所有方法，不受修饰符限制
        Method[] declaredMethods = test03SonClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod.getName());
        }

        //通过包名创建Class对象
        Class<?> aClass = Class.forName("study.reflection.Test03Son");
        //通过反射创建对象，本质是调用了类的无参构造器，如果类中没有声明无参构造器，则会报错
        Test03Son test03Son1 = (Test03Son) aClass.newInstance();
    }
}
