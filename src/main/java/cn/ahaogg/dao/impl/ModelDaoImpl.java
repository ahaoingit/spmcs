package cn.ahaogg.dao.impl;

import cn.ahaogg.dao.ModelDao;
import cn.ahaogg.domain.Model;
import cn.ahaogg.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ModelDaoImpl implements ModelDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    //查询机器型号相关信息
    @Override
    public Model findMold(String m_model) throws SQLException {
        String sql = "select * from model where m_model = ?";
        Model model = qr.query(sql, new BeanHandler<Model>(Model.class),m_model);
        return model;
    }
}
