package study.socket;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author qinb
 * socket服务端
 * @date 2021/9/29 16:00
 */
public class TcpServerDemo02 {
    @SneakyThrows
    public static void main(String[] args) {
        //创建socket服务端
        ServerSocket serverSocket = new ServerSocket(9999);
        //接收客户端
        Socket accept = serverSocket.accept();
        //接收客户端发送的信息
        InputStream is = accept.getInputStream();
        //接收文件输出流
        FileOutputStream fos = new FileOutputStream(new File("receive2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        //通知客户端已经接收完毕，可以断开连接
        OutputStream os = accept.getOutputStream();
        os.write("服务端已经接收完毕，可以断开连接".getBytes(StandardCharsets.UTF_8));

        //关闭资源
        os.close();
        fos.close();
        is.close();
        accept.close();
        serverSocket.close();
    }
}
