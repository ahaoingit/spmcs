package cn.ahaogg.domain;

public class Machine {
    private String m_serialnum;
    private String m_model;
    private String user_email;
    private String m_address;

    public Machine() {
    }

    public Machine(String m_serialnum, String m_model, String user_email, String m_address) {
        this.m_serialnum = m_serialnum;
        this.m_model = m_model;
        this.user_email = user_email;
        this.m_address = m_address;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getM_address() {
        return m_address;
    }

    public void setM_address(String m_address) {
        this.m_address = m_address;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "m_serialnum='" + m_serialnum + '\'' +
                ", m_model='" + m_model + '\'' +
                ", user_email='" + user_email + '\'' +
                ", m_address='" + m_address + '\'' +
                '}';
    }
}
