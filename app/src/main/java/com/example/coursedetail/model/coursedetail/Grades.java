package com.example.coursedetail.model.coursedetail;

public class Grades {
    private int id;
    private String name;
    private String ename;
    private int digit;
    private String alias;
    private int division_id;
    private int school_year;
    private String sort_flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public int getSchool_year() {
        return school_year;
    }

    public void setSchool_year(int school_year) {
        this.school_year = school_year;
    }

    public String getSort_flag() {
        return sort_flag;
    }

    public void setSort_flag(String sort_flag) {
        this.sort_flag = sort_flag;
    }
}
