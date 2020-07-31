package com.example.coursedetail.model.coursesList;

import com.example.coursedetail.model.courseDetail.Activities;
import com.example.coursedetail.model.courseDetail.Class;
import com.example.coursedetail.model.courseDetail.Difficulty;
import com.example.coursedetail.model.courseDetail.Evaluation;
import com.example.coursedetail.model.courseDetail.LiveSyllabus;
import com.example.coursedetail.model.courseDetail.Price;
import com.example.coursedetail.model.courseDetail.Services;
import com.example.coursedetail.model.courseDetail.Summary;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataCourses {

    private List<CoursesList> courseList;

    public List<CoursesList> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CoursesList> courseList) {
        this.courseList = courseList;
    }
}
