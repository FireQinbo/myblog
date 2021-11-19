package study.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author qinb
 * 测试upd聊天接收方
 * @date 2021/9/30 14:01
 */
public class UdpReceiverDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        DatagramSocket datagramSocket = new DatagramSocket(6666);

        //阻塞式接收包裹
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
            //接收包裹
            datagramSocket.receive(datagramPacket);

            //读取数据
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, data.length);

            System.out.println("s = " + s);
            if ("bye".equals(s.trim())) {
                break;
            }
        }

        datagramSocket.close();
    }
}
