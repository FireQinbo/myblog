package study.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author qinb
 * //测试UDP发送广播
 * @date 2021/9/30 11:12
 */
public class TestUdpClientDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //创建一个socket
        DatagramSocket datagramSocket = new DatagramSocket();
        //建一个数据包
        String msg = "你们好啊！！！";
        InetAddress inetAddress = InetAddress.getByName("localhost");
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), 0, msg.getBytes(StandardCharsets.UTF_8).length, inetAddress, 9090);
        //发送包
        datagramSocket.send(datagramPacket);
        //关闭资源
        datagramSocket.close();
    }
}
