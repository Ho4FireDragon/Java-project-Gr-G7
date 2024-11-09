package com.shopkoi.shopkoi.dto;

import lombok.Getter;

@Getter
public class BlogRequest {
    // Getters và Setters
    private String blogTitle;
    private String blogContent;
    private Long blogSlugId;

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public void setBlogSlugId(Long blogSlugId) {
        this.blogSlugId = blogSlugId;
    }
}
