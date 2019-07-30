package cn.ahaogg.domain;

public class Switch {
    private String s_code;
    private String s_desc;

    public Switch() {
    }

    public Switch(String s_code, String s_desc) {
        this.s_code = s_code;
        this.s_desc = s_desc;
    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "s_code='" + s_code + '\'' +
                ", s_desc='" + s_desc + '\'' +
                '}';
    }
}
