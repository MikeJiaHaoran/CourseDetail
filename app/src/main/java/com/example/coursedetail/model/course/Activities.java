package com.example.coursedetail.model.course;

import java.util.List;

public class Activities {
    private String name;
    private List<ActivitiesList> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActivitiesList> getList() {
        return list;
    }

    public void setList(List<ActivitiesList> list) {
        this.list = list;
    }
}
