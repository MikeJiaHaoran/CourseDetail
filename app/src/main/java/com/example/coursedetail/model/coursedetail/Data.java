package com.example.coursedetail.model.coursedetail;

import com.google.gson.annotations.SerializedName;

public class Data {
    private String courseId;
    private String courseName;
    private String subtitle;
    private String category;
    private String courseType;
    private String schoolTimeName;
    private Difficulty difficulty;
    private Price price;
    private Summary summary;
    private Object evaluation;
    private LiveSyllabus syllabus;
    private GroupOnCourseInfo grouponCourseInfo;

    @SerializedName("class")
    private Class courseClass;
    private Activities activities;
    private Services services;

    public Activities getActivities() {
        return activities;
    }

    public void setActivities(Activities activities) {
        this.activities = activities;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Class getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(Class courseClass) {
        this.courseClass = courseClass;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getSchoolTimeName() {
        return schoolTimeName;
    }

    public void setSchoolTimeName(String schoolTimeName) {
        this.schoolTimeName = schoolTimeName;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public LiveSyllabus getLiveSyllabus() {
        return syllabus;
    }

    public void setLiveSyllabus(LiveSyllabus liveSyllabus) {
        this.syllabus = liveSyllabus;
    }

    public GroupOnCourseInfo getGrouponCourseInfo() {
        return grouponCourseInfo;
    }

    public void setGrouponCourseInfo(GroupOnCourseInfo grouponCourseInfo) {
        this.grouponCourseInfo = grouponCourseInfo;
    }

    public Object getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Object evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Data{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", category='" + category + '\'' +
                ", courseType='" + courseType + '\'' +
                ", schoolTimeName='" + schoolTimeName + '\'' +
                ", difficulty=" + difficulty +
                ", price=" + price +
                ", summary=" + summary +
                ", evaluation=" + evaluation +
                ", liveSyllabus=" + syllabus +
                ", grouponCourseInfo=" + grouponCourseInfo +
                ", courseClass=" + courseClass +
                ", activities=" + activities +
                ", services=" + services +
                '}';
    }
}
