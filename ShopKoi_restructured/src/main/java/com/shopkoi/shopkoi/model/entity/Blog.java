package com.shopkoi.shopkoi.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BlogId;

    private String BlogTitle;

    private String BlogContent;

    @ManyToOne
    @JoinColumn(name = "blog_slug_id")
    private BlogSlug blogSlug;

    public Blog( String blogTitle, String blogContent, BlogSlug blogSlug) {
        BlogTitle = blogTitle;
        BlogContent = blogContent;
        this.blogSlug = blogSlug;
    }

    public Long getBlogId() {
        return BlogId;
    }

    public void setBlogId(Long blogId) {
        BlogId = blogId;
    }

    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }

    public String getBlogContent() {
        return BlogContent;
    }

    public void setBlogContent(String blogContent) {
        BlogContent = blogContent;
    }

    public BlogSlug getBlogSlug() {
        return blogSlug;
    }

    public void setBlogSlug(BlogSlug blogSlug) {
        this.blogSlug = blogSlug;
    }

    public Blog() {}


}
