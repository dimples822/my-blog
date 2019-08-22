package com.site.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import lombok.Data;

/**
 * <br>评论</br>
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/22
 */
@Data
public class BlogComment {
    private Long commentId;

    private Long blogId;

    private String commentator;

    private String email;

    private String websiteUrl;

    private String commentBody;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentCreateTime;

    private String commentatorIp;

    private String replyBody;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyCreateTime;

    private Byte commentStatus;

    private Byte isDeleted;

}