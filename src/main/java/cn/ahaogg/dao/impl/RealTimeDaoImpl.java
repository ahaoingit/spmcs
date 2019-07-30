package cn.ahaogg.dao.impl;

import cn.ahaogg.dao.RealTimeDao;
import cn.ahaogg.domain.RealTime;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RealTimeDaoImpl implements RealTimeDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());


    @Override
    public RealTime getRealTime(String m_serialnum) throws SQLException {
        String sql = "select * from realtime where time in (select Max(time) from realtime where m_serialnum = ?)";
        RealTime realTime = qr.query(sql, new BeanHandler<RealTime>(RealTime.class), m_serialnum);
        return realTime;
    }

    @Override
    public List<RealTime> findRealTimeAll(String m_serialnum, String time) throws SQLException {
        String format = time+"%";
        String sql = "select * from realtime where time LIKE ? and m_serialnum = ?";
        List<RealTime> realTimes = qr.query(sql, new BeanListHandler<RealTime>(RealTime.class),format, m_serialnum);
        return realTimes;
    }
}
