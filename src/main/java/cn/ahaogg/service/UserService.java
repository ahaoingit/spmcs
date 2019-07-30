package cn.ahaogg.service;

import cn.ahaogg.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User login(String user_email, String user_pwd) throws SQLException;
    boolean register(User user);
    int changPwd(String m_mold, String m_serialnum, String user_name, String user_email, String user_phonenum, String user_new_pwd);
    User findUser(String user_email);
    List<User> findUserAll();
}
