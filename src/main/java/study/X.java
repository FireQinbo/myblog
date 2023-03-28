package study;

import org.apache.tomcat.jni.Thread;

/**
 * Created with IntelliJ IDEA
 *
 * @author qinbo
 * @version 1.0.0 v
 * @date 2022-03-10 08:49
 * @description：x
 * @modified By：
 */
public class X extends Thread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        System.out.println("this is run()");
    }

    public static void main(String[] args) {

    }
}
