package com.example.coursedetail.model.coursesList;

import com.example.coursedetail.model.courseDetail.ClassCounselor;

import java.util.List;

public class ClassCourses {
    private String id;
    private String counselorId;
    private int showCounselorTeacher;
    private int leftNum;
    private String leftNumDesc;
    private Counselor counselor;

    public Counselor getCounselor() {
        return counselor;
    }

    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(String counselorId) {
        this.counselorId = counselorId;
    }

    public int getShowCounselorTeacher() {
        return showCounselorTeacher;
    }

    public void setShowCounselorTeacher(int showCounselorTeacher) {
        this.showCounselorTeacher = showCounselorTeacher;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public String getNumDesc() {
        return leftNumDesc;
    }

    public void setNumDesc(String numDesc) {
        this.leftNumDesc = numDesc;
    }

}
