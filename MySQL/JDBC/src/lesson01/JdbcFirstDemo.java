package lesson01;

import java.sql.*;

//我的第一个jdbc程序
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //使用注解，会初始化静态变量和静态代码块，而驱动的核心代码就写在静态代码块中，所以可以直接使用注解加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息和url
        //useUnicode=true&characterEncoding=utf8&useSSL=false,使用unicode编码，选择utf-8编码，不使用ssl
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        /*url分析
        jdbc:mysql:                                             可以看成协议例如http:
        localhoset:3306                                         服务器的ip和服务的端口号
        ?useUnicode=true&characterEncoding=utf8&useSSL=false    ?参数1&参数2&参数3& ...

        */
        String username = "root";
        String password = "wz123456789";
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //connection相当于获得了数据库的对象,意味着可以通过代码直接操作数据库，例如 事务提交 事务回滚 设置自动提交

        //4.创建SQL对象
        Statement statement = connection.createStatement();
        //5.执行语句
        String sql  ="select * from users";
        ResultSet resultSet = statement.executeQuery(sql);//进行查找
        while (resultSet.next()){
            System.out.println("id:"+resultSet.getObject("id"));
            System.out.println("name:"+resultSet.getObject("name"));
            System.out.println("pwd:"+resultSet.getObject("password"));
            System.out.println("email:"+resultSet.getObject("email"));
            System.out.println("birthday:"+resultSet.getObject("birthday"));
        }
        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
