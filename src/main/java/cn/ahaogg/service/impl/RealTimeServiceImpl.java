package cn.ahaogg.service.impl;

import cn.ahaogg.dao.RealTimeDao;
import cn.ahaogg.domain.RealTime;
import cn.ahaogg.service.RealTimeService;
import cn.ahaogg.utils.BeanFactory;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealTimeServiceImpl implements RealTimeService {
    private RealTimeDao realTimeDao = BeanFactory.newInstance(RealTimeDao.class);
    @Override
    public RealTime findRealTime(String m_serialnum) {
        RealTime realTime = null;
        try {
            realTime = realTimeDao.getRealTime(m_serialnum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realTime;
    }

    @Override
    public List<RealTime> findRealTimeAll(String m_serialnum, String time) {
        List<RealTime> realTimeAll = new ArrayList<>();
        try {
             realTimeAll = realTimeDao.findRealTimeAll(m_serialnum, time);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  realTimeAll;
    }
}
