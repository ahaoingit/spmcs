package cn.ahaogg.dao;

import cn.ahaogg.domain.Machine;

import java.sql.SQLException;
import java.util.List;

public interface MachineDao {
    Machine findMachine(String m_serialnum) throws SQLException;
    List<Machine> findMachineAll() throws SQLException;
    List<Machine> findMachineAll(String m_serialnum) throws SQLException;
    int addMachine(Machine machine) throws SQLException;
}
