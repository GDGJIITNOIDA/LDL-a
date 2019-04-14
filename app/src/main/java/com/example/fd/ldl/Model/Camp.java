package com.example.fd.ldl.Model;

public class Camp {

    int id;
    String name;
    String location;
    boolean is_active;
    String started;

    public Camp(String name, String location, boolean is_active, String started) {
        this.name = name;
        this.location = location;
        this.is_active = is_active;
        this.started = started;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }
}
