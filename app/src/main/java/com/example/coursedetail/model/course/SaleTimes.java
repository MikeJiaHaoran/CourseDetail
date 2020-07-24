package com.example.coursedetail.model.course;

public class SaleTimes {
    private String saleTime;
    private String haltSaleTime;
    private int saleStatus;
    private String reminder;

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }

    public String getHaltSaleTime() {
        return haltSaleTime;
    }

    public void setHaltSaleTime(String haltSaleTime) {
        this.haltSaleTime = haltSaleTime;
    }

    public int getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }
}
