package com.example.coursedetail.model.course;

import java.util.List;

public class LiveSyllabus {
    private String name;
    private int showSyllabusStatus;
    private int count;
    private String desc;
    private List<LiveSyllabusList> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShowSyllabusStatus() {
        return showSyllabusStatus;
    }

    public void setShowSyllabusStatus(int showSyllabusStatus) {
        this.showSyllabusStatus = showSyllabusStatus;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<LiveSyllabusList> getList() {
        return list;
    }

    public void setList(List<LiveSyllabusList> list) {
        this.list = list;
    }
}
