package study.udp;

/**
 * @author qinb
 * @date 2021/9/30 15:02
 */
public class ClientStudent {
    public static void main(String[] args) {
        new Thread(new TalkSender(7777, "localhost", 6666)).start();
        new Thread(new TalkRecevicer(8888, "老师")).start();
    }
}
