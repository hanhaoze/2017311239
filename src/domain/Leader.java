package domain;

public class Leader {
    private String t_id;
    private String t_name;
    private String t_sex;
    private String t_postion;
    private String t_phone;
    private String t_email;
    private String t_password;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_postion() {
        return t_postion;
    }

    public void setT_postion(String t_postion) {
        this.t_postion = t_postion;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_sex='" + t_sex + '\'' +
                ", t_postion='" + t_postion + '\'' +
                ", t_phone='" + t_phone + '\'' +
                ", t_email='" + t_email + '\'' +
                ", t_password='" + t_password + '\'' +
                '}';
    }
}
