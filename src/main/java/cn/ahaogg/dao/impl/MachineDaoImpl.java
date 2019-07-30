package cn.ahaogg.dao.impl;

import cn.ahaogg.dao.MachineDao;
import cn.ahaogg.dao.VerifyMachineDao;
import cn.ahaogg.domain.Machine;
import cn.ahaogg.utils.BeanFactory;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MachineDaoImpl implements MachineDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    private VerifyMachineDao verifyMachineDao = BeanFactory.newInstance(VerifyMachineDao.class);
    @Override
    public Machine findMachine(String m_serialnum) throws SQLException {
        String sql = "select * from Machine where m_serialnum = ?";
        Machine machine = qr.query(sql, new BeanHandler<Machine>(Machine.class), m_serialnum);
        return machine;
    }
    //后台 查看所有用户机械
    @Override
    public List<Machine> findMachineAll() throws SQLException {
        String sql = "select * from Machine ";
        List<Machine> machineList = qr.query(sql, new BeanListHandler<Machine>(Machine.class));
        return machineList;
    }
    //查询用户自己的所有机器
    @Override
    public List<Machine> findMachineAll(String user_email) {
        String sql = "select * from machine where user_email = ?";
        List<Machine> machineList = null;
        try {
            machineList = qr.query(sql, new BeanListHandler<Machine>(Machine.class),user_email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machineList;
    }
    //添加机械
    @Override
    public int addMachine(Machine machine) throws SQLException {

        //默认为0 用来返回 判断 是否插入
        int update = 0;
        //判断机械表里是否已经存在此机械 不存在 执行if 存在 返回0 需要进一步创表 来验证此机械是否存在
        if((findMachine(machine.getM_serialnum()) == null) && (verifyMachineDao.verify(machine.getM_serialnum(),machine.getM_model())!=null)){
        String sql = "insert into machine values(?,?,?,?)";
        update = qr.update(sql,machine.getM_serialnum(),machine.getM_model(),machine.getM_address(),machine.getUser_email());
        }
        return  update;
    }
}
