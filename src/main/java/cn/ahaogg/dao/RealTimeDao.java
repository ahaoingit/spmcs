package cn.ahaogg.dao;

import cn.ahaogg.domain.RealTime;

import java.sql.SQLException;
import java.util.List;

public interface RealTimeDao {
    RealTime getRealTime(String m_serialnum) throws SQLException;
    List<RealTime> findRealTimeAll(String m_serialnum, String time) throws SQLException;
}
