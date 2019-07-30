package cn.ahaogg.dao;

import cn.ahaogg.domain.Model;

import java.sql.SQLException;
import java.util.List;

public interface ModelDao {
    Model findMold(String m_model) throws SQLException;
}
