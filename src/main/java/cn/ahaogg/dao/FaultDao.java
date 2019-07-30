package cn.ahaogg.dao;

import cn.ahaogg.domain.Fault;

import java.sql.SQLException;
import java.util.List;

public interface FaultDao {
   Fault findFault(String f_code) throws SQLException;
   boolean changeFaultInfo(String f_code,String f_desc) throws SQLException;
}
