package lesson01;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost",8080);
        //显示socket信息
        System.out.println(socketAddress);
        //显示socket绑定的主机名
        System.out.println(socketAddress.getHostName());
        //显示socket绑定的ip地址
        System.out.println(socketAddress.getAddress());
        //显示socket绑定的端口号
        System.out.println(socketAddress.getPort());

    }
}
