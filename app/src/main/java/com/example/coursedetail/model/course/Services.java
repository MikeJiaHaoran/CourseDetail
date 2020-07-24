package com.example.coursedetail.model.course;

import java.util.List;

public class Services {
    private String name;
    private List<ServicesList> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ServicesList> getList() {
        return list;
    }

    public void setList(List<ServicesList> list) {
        this.list = list;
    }
}
