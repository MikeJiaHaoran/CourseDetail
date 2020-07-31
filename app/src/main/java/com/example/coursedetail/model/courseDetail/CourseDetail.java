package com.example.coursedetail.model.courseDetail;

public class CourseDetail {
   private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "result=" + result +
                '}';
    }
}
