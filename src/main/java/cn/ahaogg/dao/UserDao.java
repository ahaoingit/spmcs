package cn.ahaogg.dao;

import cn.ahaogg.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User login(String user_email, String user_pwd) throws SQLException;
    boolean register(User user) throws SQLException;
    //改密  型号  序列号  姓名 邮件 电话 新密码
    int changPwd(String m_model, String m_serialnum, String user_name, String user_email, String user_phonenum, String user_new_pwd) throws SQLException;
    //查询用户
    User findUser(String user_email) throws SQLException;
    //查询所有用户
    List<User> findUserAll() throws SQLException;

}
