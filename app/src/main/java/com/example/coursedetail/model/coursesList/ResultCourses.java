package com.example.coursedetail.model.coursesList;

import com.example.coursedetail.model.courseDetail.Data;

public class ResultCourses {
    private int status;
    private int rows;
    private DataCourses data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public DataCourses getData() {
        return data;
    }

    public void setData(DataCourses data) {
        this.data = data;
    }
}
