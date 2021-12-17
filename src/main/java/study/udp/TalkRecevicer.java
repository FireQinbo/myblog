package study.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author qinb
 * @date 2021/9/30 14:31
 */
public class TalkRecevicer implements Runnable{
    private DatagramSocket datagramSocket;

    private int fromPort;
    private String fromName;

    @SneakyThrows
    public TalkRecevicer(int fromPort, String fromName) {
        this.fromName = fromName;
        this.fromPort = fromPort;
        datagramSocket = new DatagramSocket(fromPort);
    }

    @Override
    public void run() {
        this.receiveMsg();
    }

    /**
     * 接收消息
     */
    @SneakyThrows
    public void receiveMsg() {
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(datagramPacket);

            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, data.length);
            System.out.println(fromName + ":" + s);

            if ("bye".equals(s.trim())) {
                break;
            }
        }

        datagramSocket.close();
    }
}
