package study.udp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author qinb
 * 多线程测试网络聊天
 * @date 2021/9/30 14:28
 */
public class TalkSender implements Runnable{
    private DatagramSocket datagramSocket;
    private int fromPort;
    private String toIp;
    private int toPort;

    @SneakyThrows
    public TalkSender(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        datagramSocket = new DatagramSocket(fromPort);
    }

    @Override
    public void run() {
        this.sendMsg();
    }

    /**
     * 发送消息
     */
    @SneakyThrows
    public void sendMsg() {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String sendContent = bufferedReader.readLine();

            byte[] contentBytes = sendContent.getBytes(StandardCharsets.UTF_8);

            DatagramPacket datagramPacket = new DatagramPacket(contentBytes, 0, contentBytes.length, new InetSocketAddress(toIp, toPort));
            datagramSocket.send(datagramPacket);

            if ("bye".equals(sendContent.trim())) {
                break;
            }
        }

        datagramSocket.close();
    }
}
