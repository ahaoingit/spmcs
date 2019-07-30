package cn.ahaogg.service.impl;

import cn.ahaogg.dao.ModelDao;
import cn.ahaogg.domain.Model;
import cn.ahaogg.service.ModelService;
import cn.ahaogg.utils.BeanFactory;

import java.sql.SQLException;

public class ModelServiceImpl implements ModelService {
    private ModelDao modelDao = BeanFactory.newInstance(ModelDao.class);
    @Override
    public Model findModel(String m_model) {
        Model model = null;
        try {
            model = modelDao.findMold(m_model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
