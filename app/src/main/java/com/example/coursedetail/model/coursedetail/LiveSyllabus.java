package com.example.coursedetail.model.coursedetail;

import java.util.List;

public class LiveSyllabus {
    private String name;
    private int showSyllabusStatus;
    private int count;
    private String desc;
    private List<LiveSyllabusList2> list;

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

    public List<LiveSyllabusList2> getList() {
        return list;
    }

    public void setList(List<LiveSyllabusList2> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LiveSyllabus{" +
                "name='" + name + '\'' +
                ", showSyllabusStatus=" + showSyllabusStatus +
                ", count=" + count +
                ", desc='" + desc + '\'' +
                ", list=" + list +
                '}';
    }
}
