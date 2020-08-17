package com.example.coursedetail.model.courseslist;

public class ClassCourses {
    private String id;
    private String counselorId;
    private int showCounselorTeacher;
    private int leftNum;
    private String leftNumDesc;
    private Object counselor;

    public Object getCounselor() {
        return counselor;
    }

    public void setCounselor(Object counselor) {
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
