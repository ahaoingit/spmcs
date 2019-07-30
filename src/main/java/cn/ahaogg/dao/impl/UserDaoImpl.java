package cn.ahaogg.dao.impl;

import cn.ahaogg.dao.UserDao;
import cn.ahaogg.domain.User;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    /*
    * 用户的登录功能
    * @return User
    * */
    @Override
    public User login(String user_email, String user_pwd) throws SQLException {

        String sql = "select * from user where user_email = ? and user_pwd = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), user_email, user_pwd);
        return  user;
    }

    /*
     * 注册功能
     * */
    @Override
    public boolean register(User user) throws SQLException {
        if (findUser(user.getUser_email()) == null){
        String sql = "insert into user values (?,?,?,?,?)";
        qr.update(sql, user.getUser_email(), user.getUser_phonenum(), user.getUser_pwd(), user.getUser_name(),user.getUser_country());
        return true;
        }else {
            return false;
        }
    }
    /*
    * 忘记密码
    * */
    @Override
    public  int  changPwd(String m_model, String m_serialnum, String user_name, String user_email, String user_phonenum, String user_new_pwd) throws SQLException {
        String sql = "UPDATE  `user` , machine  set user_pwd = ? where `user`.user_email = machine.user_email and  machine.m_model = ? and  machine.m_serialnum = ? and user_name = ? and user.user_email = ? and user_phonenum = ? ";
        int update = qr.update(sql, user_new_pwd, m_model, m_serialnum, user_name, user_email, user_phonenum);
        return  update;
    }

    @Override
    public User findUser(String user_email) throws SQLException {
        String sql = "select * from user where user_email = ? ";
        User user_find = qr.query(sql,new BeanHandler<User>(User.class),user_email);
        return user_find;
    }

    @Override
    public List<User> findUserAll() throws SQLException {
        String sql = "select * from user";
        List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class));
        return userList;
    }


}
