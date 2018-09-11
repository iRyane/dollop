package com.cx.bank.mybatis;

public class Record {
    private int id;
    private String name;
    private String records;
    private String time;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord() {
        return records;
    }

    public void setRecord(String record) {
        this.records = record;
    }

}
