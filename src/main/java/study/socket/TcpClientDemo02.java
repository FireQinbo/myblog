package study.socket;

import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qinb
 * socket客户端
 * @date 2021/9/29 15:59
 */
public class TcpClientDemo02 {

    @SneakyThrows
    public static void main(String[] args) {
        //创建socket客户端
        Socket socket = new Socket(InetAddress.getByName("localhost"), 9999);
        //获取输出流
        OutputStream os = socket.getOutputStream();
        //读取文件
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //客户端发送信息完毕,关闭输出流
        socket.shutdownOutput();
        //接收到服务端的关闭通知
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len2;
        while ((len2 = is.read(bytes)) != -1) {
            baos.write(bytes, 0, len2);
        }
        System.out.println("baos.toString() = " + baos.toString());
    }
}
