package com.wxy.pojo;

public class Leave {

    private Integer l_id;
    private String l_content;
    private String l_time;
    private Integer u_id;
    private Integer m_id;
    private String u_name;

    public Leave() {
    }

    public Leave(Integer l_id, String l_content, String l_time, Integer u_id, Integer m_id, String u_name) {
        this.l_id = l_id;
        this.l_content = l_content;
        this.l_time = l_time;
        this.u_id = u_id;
        this.m_id = m_id;
        this.u_name = u_name;
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public String getL_content() {
        return l_content;
    }

    public void setL_content(String l_content) {
        this.l_content = l_content;
    }

    public String getL_time() {
        return l_time;
    }

    public void setL_time(String l_time) {
        this.l_time = l_time;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "l_id=" + l_id +
                ", l_content='" + l_content + '\'' +
                ", l_time='" + l_time + '\'' +
                ", u_id=" + u_id +
                ", m_id=" + m_id +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
