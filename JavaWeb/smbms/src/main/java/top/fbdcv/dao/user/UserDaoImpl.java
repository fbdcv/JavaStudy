package top.fbdcv.dao.user;

import top.fbdcv.dao.BaseDao;
import top.fbdcv.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) {
        User user =null;
        String sql = "select * from smbms_user where userCode=?";
        PreparedStatement statement =null;
        Object[] params ={userCode};
        ResultSet resultSet = null;
        resultSet = BaseDao.executeQuery(connection,statement,sql,params);
        if(resultSet!=null){
            try {
                if (resultSet.next()){
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(resultSet.getDate("creationDate"));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(resultSet.getDate("modifyDate"));
                }
                //释放sql连接资源
                BaseDao.releaseResource(connection,statement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
