package study.udp;

/**
 * @author qinb
 * @date 2021/9/30 15:05
 */
public class ClientTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSender(9999, "localhost", 8888)).start();
        new Thread(new TalkRecevicer(6666, "学生")).start();
    }
}
