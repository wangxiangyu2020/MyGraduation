package com.wxy.pojo;

import java.util.List;

public class Message {

    private Integer m_id;
    private String m_title;
    private String m_content;
    private String m_time;
    private Integer u_id;
    private String u_name;
    private List<Leave> leave;
    private Integer m_views;

    public Message() {
    }

    public Message(Integer m_id, String m_title, String m_content, String m_time, Integer u_id, String u_name, List<Leave> leave, Integer m_views) {
        this.m_id = m_id;
        this.m_title = m_title;
        this.m_content = m_content;
        this.m_time = m_time;
        this.u_id = u_id;
        this.u_name = u_name;
        this.leave = leave;
        this.m_views = m_views;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_content() {
        return m_content;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }

    public String getM_time() {
        return m_time;
    }

    public void setM_time(String m_time) {
        this.m_time = m_time;
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

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }

    public Integer getM_views() {
        return m_views;
    }

    public void setM_views(Integer m_views) {
        this.m_views = m_views;
    }

    @Override
    public String toString() {
        return "Message{" +
                "m_id=" + m_id +
                ", m_title='" + m_title + '\'' +
                ", m_content='" + m_content + '\'' +
                ", m_time='" + m_time + '\'' +
                ", u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", leave=" + leave +
                ", m_views=" + m_views +
                '}';
    }
}
