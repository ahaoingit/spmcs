package cn.ahaogg.domain;

public class User {

    private String user_email;
    private String user_phonenum;
    private String user_pwd;
    private String user_name;
    private String user_country;

    public User(String user_email, String user_phonenum, String user_pwd, String user_name, String user_country) {
        this.user_email = user_email;
        this.user_phonenum = user_phonenum;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_country = user_country;
    }

    public User() {
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phonenum() {
        return user_phonenum;
    }

    public void setUser_phonenum(String user_phonenum) {
        this.user_phonenum = user_phonenum;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_email='" + user_email + '\'' +
                ", user_phonenum='" + user_phonenum + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_country='" + user_country + '\'' +
                '}';
    }
}
