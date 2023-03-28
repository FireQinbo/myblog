package study.udp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author qinbo
 * @version 1.0.0 v
 * @date 2022-03-09 16:52
 * @description：test2
 * @modified By：
 */
public class Test2 {
    public static void main(String[] args) {
        for (int cnt = 0; cnt < 10; cnt++) {
            if (cnt == 5)
                break;
            System.out.print(cnt);
        }

    }

}

class T8 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "," + b);
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}

class T9 {
    public static void main(String[] args) {
        List list = new ArrayList();
        int index = 2;
        boolean[] test = new boolean[3];
        boolean tt = test [index];
        for (boolean b : test) {
            System.out.println("b = " + b);
        }
        System.out.println("tt = " + tt);
    }

}


