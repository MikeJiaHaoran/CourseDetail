package com.example.coursedetail.model.news;

import java.util.List;

public class LatestNews {
    private String date;
    private List<Stories> stories;
    private List<TopStories> top_stories;

    public List<Stories> getStories() {
        return stories;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }

    public List<TopStories> getTopStories() {
        return top_stories;
    }

    public void setTopStories(List<TopStories> topStories) {
        this.top_stories = topStories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
