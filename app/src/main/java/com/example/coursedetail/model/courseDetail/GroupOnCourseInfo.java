package com.example.coursedetail.model.courseDetail;

import java.util.List;

public class GroupOnCourseInfo {
    private List<String> imgInfos;

    public List<String> getImgInfos() {
        return imgInfos;
    }

    public void setImgInfos(List<String> imgInfos) {
        this.imgInfos = imgInfos;
    }

    @Override
    public String toString() {
        return "GroupOnCourseInfo{" +
                "imgInfos=" + imgInfos +
                '}';
    }
}
