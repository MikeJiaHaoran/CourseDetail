package com.example.coursedetail.model.courseDetail;

import java.util.List;

public class EvaluationList {
    private String name;
    private String time;
    private String avatar;
    List<EvaluateTag> evaluateTag;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<EvaluateTag> getEvaluateTag() {
        return evaluateTag;
    }

    public void setEvaluateTag(List<EvaluateTag> evaluateTag) {
        this.evaluateTag = evaluateTag;
    }
}
