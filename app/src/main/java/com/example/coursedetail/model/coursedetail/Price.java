package com.example.coursedetail.model.coursedetail;

public class Price {
    private String originPrice;
    private String resale;
    private int groupPrice;
    private String originalText;

    public String getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }

    public String getResale() {
        return resale;
    }

    public void setResale(String resale) {
        this.resale = resale;
    }

    public int getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(int groupPrice) {
        this.groupPrice = groupPrice;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }
}
