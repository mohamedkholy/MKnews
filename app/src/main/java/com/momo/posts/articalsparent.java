package com.momo.posts;

import java.util.ArrayList;
import java.util.List;

public class articalsparent {
    String status;
    int totalResults;
    List<arical>  articles;

    public articalsparent(String status, int totalResults, List<arical> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<arical> getArticles() {
        return articles;
    }

    public void setArticles(List<arical> articles) {
        this.articles = articles;
    }
}
