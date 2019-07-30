package cn.ahaogg.dao.impl;
import cn.ahaogg.dao.FaultDao;
import cn.ahaogg.domain.Fault;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

public class FaultDaoImpl implements FaultDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public Fault findFault(String f_code) throws SQLException {
        String sql = "select * from fault where f_code = ?";
        return qr.query(sql,new BeanHandler<Fault>(Fault.class),f_code);
    }

    @Override
    public boolean changeFaultInfo(String f_code, String f_desc) throws SQLException {
        String sql = "update fault set f_desc = ? where f_code = ?";
        int update = qr.update(sql, f_code, f_desc);
        if (update>0){
            return true;
        }else {
            return false;
        }
    }
}
