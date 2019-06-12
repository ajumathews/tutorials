package com.grace.tutorials.springboot;

public class Room {

    private long number;
    private String name;
    private String info;

    public Room() {
        super();
    }

    public Room(long number, String name, String info) {
        super();
        this.number = number;
        this.name = name;
        this.info = info;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
