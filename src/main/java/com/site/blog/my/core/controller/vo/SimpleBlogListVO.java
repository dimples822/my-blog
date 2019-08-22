package com.site.blog.my.core.controller.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * <br>A简介博客页面<br/>
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/22
 */
@Data
public class SimpleBlogListVO implements Serializable {

    private Long blogId;

    private String blogTitle;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
