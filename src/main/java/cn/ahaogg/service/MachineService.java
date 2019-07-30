package cn.ahaogg.service;

import cn.ahaogg.domain.Machine;

import java.sql.SQLException;
import java.util.List;

public interface MachineService {
    Machine findMachine(String m_serialnum) throws SQLException;
    List<Machine> findMachineAll() throws SQLException;
    List<Machine> findMachineAll(String user_email);
    boolean addMachine(Machine machine);
}
