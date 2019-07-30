package cn.ahaogg.domain;

public class VerifyMachine {
    private  String m_serialnum;
    private  String m_model;

    public VerifyMachine() {
    }

    public VerifyMachine(String m_serialnum, String m_model) {
        this.m_serialnum = m_serialnum;
        this.m_model = m_model;
    }

    public String getM_serialnum() {
        return m_serialnum;
    }

    public void setM_serialnum(String m_serialnum) {
        this.m_serialnum = m_serialnum;
    }

    public String getM_model() {
        return m_model;
    }

    public void setM_model(String m_model) {
        this.m_model = m_model;
    }

    @Override
    public String toString() {
        return "VerifyMachine{" +
                "m_serialnum='" + m_serialnum + '\'' +
                ", m_model='" + m_model + '\'' +
                '}';
    }
}
