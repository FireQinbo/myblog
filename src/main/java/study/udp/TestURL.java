package study.udp;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author qinb
 * 测试下载网络资源
 * @date 2021/9/30 15:53
 */
public class TestURL {
    @SneakyThrows
    public static void main(String[] args) {
        URL url = new URL("https://himg.bdimg.com/sys/portraitn/item/f44f68656c6c6f5f71696e626f6c60");

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("baidu.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        outputStream.close();
        inputStream.close();
        httpURLConnection.disconnect();
    }
}
