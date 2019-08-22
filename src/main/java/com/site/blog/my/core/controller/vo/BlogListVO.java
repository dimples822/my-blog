package com.site.blog.my.core.controller.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 博客列表<br/>
 *
 * @author zhongyj
 * @date 2019/8/7
 */
@Data
public class BlogListVO implements Serializable {

    private Long blogId;

    private String blogTitle;

    private String blogSubUrl;

    private String blogCoverImage;

    private Integer blogCategoryId;

    private String blogCategoryIcon;

    private String blogCategoryName;

    private Date createTime;


}
