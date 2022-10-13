package com.momo.posts;

import java.io.Serializable;
import java.net.URL;

import retrofit2.http.Url;

public class arical implements Serializable {
    source source;
    String author;
    String title;
    String description;
    URL url;
    URL urlToImage;
    String publishedAt;
    String content;

    public arical(com.momo.posts.source source, String author, String title, String description, URL url, URL urlToImage, String publishedAt, String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public com.momo.posts.source getSource() {
        return source;
    }

    public void setSource(com.momo.posts.source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(URL urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
