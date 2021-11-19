package study.udp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author qinb
 * 测试upd聊天发送方
 * @date 2021/9/30 14:01
 */
public class UdpSenderDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //通过控制台发送数据
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String data = bufferedReader.readLine();

            //参数说明：字节数据，数据开始，数据结束，要发送的地址
            DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(StandardCharsets.UTF_8), 0,
                    data.getBytes(StandardCharsets.UTF_8).length, new InetSocketAddress("localhost", 6666));

            //发送
            datagramSocket.send(datagramPacket);
            if ("bye".equals(data)) {
                break;
            }
        }

        //关闭资源
        datagramSocket.close();
    }
}
