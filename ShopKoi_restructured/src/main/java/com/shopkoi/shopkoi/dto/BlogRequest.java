package com.shopkoi.shopkoi.dto;

public class BlogRequest {
    private String blogTitle;
    private String blogContent;
    private Long blogSlugId;

    // Getters và Setters
    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Long getBlogSlugId() {
        return blogSlugId;
    }

    public void setBlogSlugId(Long blogSlugId) {
        this.blogSlugId = blogSlugId;
    }
}
