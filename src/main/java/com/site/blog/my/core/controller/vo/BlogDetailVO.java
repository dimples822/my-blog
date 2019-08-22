package com.site.blog.my.core.controller.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 博客详情<br>
 *
 * @author zhongyj
 * @date 2019/8/7
 */
@Data
public class BlogDetailVO {
    private Long blogId;

    private String blogTitle;

    private Integer blogCategoryId;

    private Integer commentCount;

    private String blogCategoryIcon;

    private String blogCategoryName;

    private String blogCoverImage;

    private Long blogViews;

    private List<String> blogTags;

    private String blogContent;

    private Byte enableComment;

    private Date createTime;

}
