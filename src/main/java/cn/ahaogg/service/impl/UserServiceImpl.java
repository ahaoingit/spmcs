package cn.ahaogg.service.impl;

import cn.ahaogg.dao.UserDao;
import cn.ahaogg.domain.User;
import cn.ahaogg.service.UserService;
import cn.ahaogg.utils.BeanFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl  implements UserService {
    private UserDao userDao = BeanFactory.newInstance(UserDao.class);
    @Override
    public User login(String user_email, String user_pwd) throws SQLException {
        User user = userDao.login(user_email, user_pwd);
        return user;
    }

    @Override
    public boolean register(User user) {
        try {
            return  userDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int changPwd(String m_mold, String m_serialnum, String user_name, String user_email, String user_phonenum, String user_new_pwd) {
        int flog = 0;
        try {
            flog = userDao.changPwd(m_mold, m_serialnum, user_name, user_email, user_phonenum, user_new_pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flog;
    }

    @Override
    public User findUser(String user_email) {
        User user = new User();
        try {
            user= userDao.findUser(user_email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findUserAll() {
        List<User> userAll = new ArrayList<>();
        try {
             userAll = userDao.findUserAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAll;
    }
}
