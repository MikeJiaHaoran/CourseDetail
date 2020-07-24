package com.example.coursedetail.model.course;

import java.util.List;

public class Evaluation {
    private String evaluationRate;
    private List<EvaluateTag> evaluateTag;
    private String title;
    private String moreEvaluation;
    private List<EvaluationList> list;

    public String getEvaluationRate() {
        return evaluationRate;
    }

    public void setEvaluationRate(String evaluationRate) {
        this.evaluationRate = evaluationRate;
    }

    public List<EvaluateTag> getEvaluateTag() {
        return evaluateTag;
    }

    public void setEvaluateTag(List<EvaluateTag> evaluateTag) {
        this.evaluateTag = evaluateTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoreEvaluation() {
        return moreEvaluation;
    }

    public void setMoreEvaluation(String moreEvaluation) {
        this.moreEvaluation = moreEvaluation;
    }

    public List<EvaluationList> getList() {
        return list;
    }

    public void setList(List<EvaluationList> list) {
        this.list = list;
    }
}
