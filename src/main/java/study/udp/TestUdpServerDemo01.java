package study.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author qinb
 * @date 2021/9/30 11:18
 */
public class TestUdpServerDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);


        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        //关闭资源
        datagramSocket.close();
    }
}
