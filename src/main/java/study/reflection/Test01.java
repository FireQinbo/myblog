package study.reflection;

import lombok.Data;
import lombok.SneakyThrows;

import javax.swing.plaf.synth.SynthToolBarUI;

/**
 * @author qinb
 * 测试反射
 * @date 2021/10/8 9:38
 */
public class Test01 extends Object{
    @SneakyThrows
    public static void main(String[] args) {
        //通过反射获取类的class对象
        //同一个类的hashcode是一样的
        Class<?> aClass = Class.forName("study.reflection.User");
        System.out.println("aClass = " + aClass);
        System.out.println("aClass.hashCode() = " + aClass.hashCode());

        Class<User> userClass = User.class;
        System.out.println("userClass = " + userClass);
        System.out.println("userClass.hashCode() = " + userClass.hashCode());

        User user = new User();
        Class<? extends User> aClass1 = user.getClass();
        System.out.println("aClass1 = " + aClass1);
        System.out.println("aClass1.hashCode() = " + aClass1.hashCode());
    }
}

@Data
class User{
    private String name;
    private int id;
}
