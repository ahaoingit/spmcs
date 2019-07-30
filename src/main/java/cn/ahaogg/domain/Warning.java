package cn.ahaogg.domain;

public class Warning {
    private  String w_code;
    private  String w_desc;
    private  String w_status;


    public Warning() {
    }

    public Warning(String w_code, String w_desc, String w_status) {
        this.w_code = w_code;
        this.w_desc = w_desc;
        this.w_status = w_status;
    }

    public String getW_code() {
        return w_code;
    }

    public void setW_code(String w_code) {
        this.w_code = w_code;
    }

    public String getW_desc() {
        return w_desc;
    }

    public void setW_desc(String w_desc) {
        this.w_desc = w_desc;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    @Override
    public String toString() {
        return "Warning{" +
                "w_code='" + w_code + '\'' +
                ", w_desc='" + w_desc + '\'' +
                ", w_status='" + w_status + '\'' +
                '}';
    }
}
