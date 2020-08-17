package com.example.coursedetail.model.courseslist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoursesList {
    private String courseId;
    private String courseName;
    private String courseType;
    private String subName;
    private PriceCourses price;
    private DifficultyCourses difficulty;
    private SyllabusNum syllabusNum;
    private String schoolTimeName;
    private List<ChineseTeacher> chineseTeacher;
    private List<ForeignTeacher> foreignTeacher;
    @SerializedName("class")
    private ClassCourses classCourses;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public PriceCourses getPrice() {
        return price;
    }

    public void setPrice(PriceCourses price) {
        this.price = price;
    }

    public DifficultyCourses getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyCourses difficulty) {
        this.difficulty = difficulty;
    }

    public SyllabusNum getSyllabusNum() {
        return syllabusNum;
    }

    public void setSyllabusNum(SyllabusNum syllabusNum) {
        this.syllabusNum = syllabusNum;
    }

    public String getSchoolTimeName() {
        return schoolTimeName;
    }

    public void setSchoolTimeName(String schoolTimeName) {
        this.schoolTimeName = schoolTimeName;
    }

    public List<ChineseTeacher> getChineseTeacher() {
        return chineseTeacher;
    }

    public void setChineseTeacher(List<ChineseTeacher> chineseTeacher) {
        this.chineseTeacher = chineseTeacher;
    }

    public List<ForeignTeacher> getForeignTeacher() {
        return foreignTeacher;
    }

    public void setForeignTeacher(List<ForeignTeacher> foreignTeacher) {
        this.foreignTeacher = foreignTeacher;
    }

    public ClassCourses getClassCourses() {
        return classCourses;
    }

    public void setClassCourses(ClassCourses classCourses) {
        this.classCourses = classCourses;
    }
}
