package study.socket;

import lombok.SneakyThrows;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author qinb
 * 测试TCP通信 客户端
 * @date 2021/9/29 15:05
 */
public class TcpClientDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //1、创建socket客户端
        InetAddress localHost = InetAddress.getLocalHost();
        Socket socket = new Socket(localHost, 9999);

        //获取输出流
        OutputStream os = socket.getOutputStream();

        //写入要发送的内容
        os.write("你好，我正在学习Socket网络编程".getBytes(StandardCharsets.UTF_8));

        //关闭流和socket连接
        os.close();
        socket.close();
    }
}
