package com.site.blog.my.core.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class NoteLabel implements Serializable {
    /**
    * 主键id
    */
    private Long id;

    /**
    * 笔记分类
    */
    private String noteLabel;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}