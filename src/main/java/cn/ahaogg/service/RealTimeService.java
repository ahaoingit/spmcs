package cn.ahaogg.service;

import cn.ahaogg.domain.RealTime;

import java.sql.SQLException;
import java.util.List;

public interface RealTimeService {
    RealTime findRealTime(String m_serialnum);
    List<RealTime> findRealTimeAll(String m_serialnum, String time);
}
