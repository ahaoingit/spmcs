package cn.ahaogg.service.impl;

import cn.ahaogg.dao.FaultDao;
import cn.ahaogg.domain.Fault;
import cn.ahaogg.service.FaultService;
import cn.ahaogg.utils.BeanFactory;

import java.sql.SQLException;

public class FaultServiceImpl implements FaultService {
    private  FaultDao faultDao = BeanFactory.newInstance(FaultDao.class);
    @Override
    public Fault findFault(String f_code) {
        Fault fault = new Fault();
        try {
             fault = faultDao.findFault(f_code);
        } catch (SQLException e) {
            System.out.println("FaultServiceImpl类出错");
        }
        return fault;
    }
}
