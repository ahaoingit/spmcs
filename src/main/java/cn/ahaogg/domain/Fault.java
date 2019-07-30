package cn.ahaogg.domain;

public class Fault {
    private String f_code;
    private String f_desc;

    public Fault() {
    }

    public Fault(String f_code, String f_desc) {
        this.f_code = f_code;
        this.f_desc = f_desc;
    }

    public String getF_code() {
        return f_code;
    }

    public void setF_code(String f_code) {
        this.f_code = f_code;
    }

    public String getF_desc() {
        return f_desc;
    }

    public void setF_desc(String f_desc) {
        this.f_desc = f_desc;
    }

    @Override
    public String toString() {
        return "Fault{" +
                "f_code='" + f_code + '\'' +
                ", f_desc='" + f_desc + '\'' +
                '}';
    }
}
