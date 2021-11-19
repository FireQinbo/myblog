package study.socket;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qinb
 * 测试TCP通信 服务端
 * @date 2021/9/29 15:06
 */
public class TcpServerDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //1、建立socket服务
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端连接
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream is = accept.getInputStream();

        //管道流处理客户端发送过来的消息
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        System.out.println("byteArrayOutputStream.toString() = " + byteArrayOutputStream.toString());

        //关闭流和socket连接
        byteArrayOutputStream.close();
        is.close();
        accept.close();
        serverSocket.close();
    }
}
