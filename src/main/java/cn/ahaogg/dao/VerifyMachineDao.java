package cn.ahaogg.dao;

import cn.ahaogg.domain.VerifyMachine;

import java.sql.SQLException;

public interface VerifyMachineDao {
    //验证机械是否存在
    VerifyMachine verify(String m_serialnum,String m_model) throws SQLException;
}
