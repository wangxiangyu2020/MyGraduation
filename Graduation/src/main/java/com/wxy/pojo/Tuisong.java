package com.wxy.pojo;

public class Tuisong {
    private int id;
    private String username;
    private String text;
    private int state;

    public Tuisong() {
    }

    public Tuisong(int id, String username, String text, int state) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tuisong{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", state=" + state +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
