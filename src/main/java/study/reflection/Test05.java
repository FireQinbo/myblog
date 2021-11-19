package study.reflection;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author qinb
 * @date 2021/10/19 16:00
 */
public class Test05 {
    //反射操作注解
    @SneakyThrows
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        //通过反射获取注解
        TableQb tableQb = studentClass.getAnnotation(TableQb.class);
        System.out.println("tableQb.value() = " + tableQb.value());

        //通过反射获取字段上面的注解
        Field name = studentClass.getDeclaredField("name");
        FieldQb fieldQb = name.getAnnotation(FieldQb.class);
        System.out.println("fieldQb.columnName() = " + fieldQb.columnName());
        System.out.println("fieldQb.type() = " + fieldQb.type());
        System.out.println("fieldQb.length() = " + fieldQb.length());
    }
}

@Data
@TableQb("db_student")
class Student {
    @FieldQb(columnName = "db_id", type = "int", length = 11)
    private int id;
    @FieldQb(columnName = "db_name", type = "varchar", length = 11)
    private String name;
    @FieldQb(columnName = "db_age", type = "int", length = 11)
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//定一个类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableQb {
    String value();
}


//定一个字段注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldQb {
    String columnName();

    String type();

    int length();
}
