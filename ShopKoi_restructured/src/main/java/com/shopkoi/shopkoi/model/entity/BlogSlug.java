package com.shopkoi.shopkoi.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "BlogSlug")
public class BlogSlug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BlogSlugId;

    private String Title;

    private String Description;

    public Long getBlogSlugId() {
        return BlogSlugId;
    }

    public void setBlogSlugId(Long blogSlugId) {
        BlogSlugId = blogSlugId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BlogSlug(Long blogSlugId, String title, String description) {
        BlogSlugId = blogSlugId;
        Title = title;
        Description = description;
    }

    public BlogSlug() {}
}
