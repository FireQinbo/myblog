package study.ip;

import lombok.SneakyThrows;

import java.net.InetAddress;

/**
 * @author qinb
 * @date 2021/9/29 14:19
 */
public class TestInetAddress {

    @SneakyThrows
    public static void main(String[] args) {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress.toString() = " + inetAddress.toString());
        System.out.println("inetAddress.getHostAddress() = " + inetAddress.getHostAddress());
        System.out.println("inetAddress.getCanonicalHostName() = " + inetAddress.getCanonicalHostName());
        System.out.println("inetAddress.getHostName() = " + inetAddress.getHostName());
        System.out.println("inetAddress.getAddress() = " + inetAddress.getAddress());
    }
}
