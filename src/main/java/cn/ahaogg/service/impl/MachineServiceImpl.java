package cn.ahaogg.service.impl;

import cn.ahaogg.dao.MachineDao;
import cn.ahaogg.domain.Machine;
import cn.ahaogg.service.MachineService;
import cn.ahaogg.utils.BeanFactory;

import java.sql.SQLException;
import java.util.List;

public class MachineServiceImpl implements MachineService {
    private MachineDao machineDao = BeanFactory.newInstance(MachineDao.class);
    public Machine findMachine(String m_serialnum) {
        Machine machine = null;
        try {
            machine = machineDao.findMachine(m_serialnum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machine;
    }

    //管理员查看所有用户机械
    @Override
    public List<Machine> findMachineAll() throws SQLException {
        List<Machine> machineAll = machineDao.findMachineAll();
        return machineAll;
    }
    //用户的所有机械
    @Override
    public List<Machine> findMachineAll(String user_email)  {
        List<Machine> machineAll = null;
        try {
            machineAll = machineDao.findMachineAll(user_email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machineAll;
    }


    @Override
    public boolean addMachine(Machine machine)  {
        int i =0;
        try {
             i = machineDao.addMachine(machine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i != 0 ){
            return true;
        }else {
            return false;
        }
    }
}
