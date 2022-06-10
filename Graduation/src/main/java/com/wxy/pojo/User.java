package com.wxy.pojo;

import java.util.List;

public class User {

    private Integer u_id;
    private String u_name;
    private String u_pwd;
    private Integer u_sex;
    private String u_phone;
    private Integer a_id;
    private List<Message> message;
    private List<Leave> leave;

    public User() {
    }

    public User(Integer u_id, String u_name, String u_pwd, Integer u_sex, String u_phone, Integer a_id, List<Message> message, List<Leave> leave) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_sex = u_sex;
        this.u_phone = u_phone;
        this.a_id = a_id;
        this.message = message;
        this.leave = leave;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public Integer getU_sex() {
        return u_sex;
    }

    public void setU_sex(Integer u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_sex=" + u_sex +
                ", u_phone='" + u_phone + '\'' +
                ", a_id=" + a_id +
                ", message=" + message +
                ", leave=" + leave +
                '}';
    }
}
