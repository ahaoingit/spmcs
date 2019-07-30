package cn.ahaogg.dao.impl;

import cn.ahaogg.dao.VerifyMachineDao;
import cn.ahaogg.domain.VerifyMachine;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class VerifyMachineImpl implements VerifyMachineDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public VerifyMachine verify(String m_serialnum, String m_model) throws SQLException {
        String sql = "select * from verifymachine where m_serialnum = ? and m_model = ?";
        VerifyMachine verifyMachine = qr.query(sql, new BeanHandler<VerifyMachine>(VerifyMachine.class), m_serialnum, m_model);
        return verifyMachine;
    }
}
