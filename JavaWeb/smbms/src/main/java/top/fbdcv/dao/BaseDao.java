package top.fbdcv.dao;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块,类加载的时候就初始化了
    static {
        //创建properties对象
        Properties properties = new Properties();
        //通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        //将db.properties中的内容写到刚才创建的properties对象中
        try {
            properties.load(is);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取数据库的连接
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

    //编写查询公共类
    public static ResultSet executeQuery(Connection connection,PreparedStatement statement,String sql,Object[] params){
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                statement.setObject(i+1,params[i]);
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  resultSet;
    }

    //编写更新公共类
    public static int executeUpdate(Connection connection,PreparedStatement statement,String sql,Object[] params){
        int change=0;
        try{
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= params.length; i++) {
                statement.setObject(i,params[i]);
            }
            change = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return change;
    }

    //释放资源
    public static boolean releaseResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag =true;
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }


}
