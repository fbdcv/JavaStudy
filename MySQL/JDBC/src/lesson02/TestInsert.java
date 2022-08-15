package lesson02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st= null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql ="insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`)"+
                    "values (4,'kuangshen','wz123456789','2434897168@qq.com','2022-08-06')";
            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }

}
