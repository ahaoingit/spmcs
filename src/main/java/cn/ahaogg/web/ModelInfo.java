package cn.ahaogg.web;

import cn.ahaogg.domain.Model;

public class ModelInfo {
    private String m_serialnum;
    private Model model;

    public ModelInfo() {
    }

    public ModelInfo(String m_serialnum, Model model) {
        this.m_serialnum = m_serialnum;
        this.model = model;
    }

    public String getM_serialnum() {
        return m_serialnum;
    }

    public void setM_serialnum(String m_serialnum) {
        this.m_serialnum = m_serialnum;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ModelInfo{" +
                "m_serialnum='" + m_serialnum + '\'' +
                ", model=" + model +
                '}';
    }
}
