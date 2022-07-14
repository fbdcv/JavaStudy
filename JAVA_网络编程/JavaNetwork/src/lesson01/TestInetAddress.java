package lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //查询本机地址
        InetAddress address = InetAddress.getByName("localhost");
        System.out.println(address);
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println(address1);
        //查询网站ip地址
        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        System.out.println(address2);

    }
}
