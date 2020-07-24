package com.example.coursedetail.model.course;

import java.util.List;

public class ChineseTeacher {
    private String id;
    private String name;
    private String spell;
    private String typeName;
    private List<String> avatars;
    private String subjectNames;
    private String gradeNames;
    private String desc;
    private String jumpType;
    private String url;
    private String detailScheme;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getAvatars() {
        return avatars;
    }

    public void setAvatars(List<String> avatars) {
        this.avatars = avatars;
    }

    public String getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(String subjectNames) {
        this.subjectNames = subjectNames;
    }

    public String getGradeNames() {
        return gradeNames;
    }

    public void setGradeNames(String gradeNames) {
        this.gradeNames = gradeNames;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getJumpType() {
        return jumpType;
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetailScheme() {
        return detailScheme;
    }

    public void setDetailScheme(String detailScheme) {
        this.detailScheme = detailScheme;
    }
}
