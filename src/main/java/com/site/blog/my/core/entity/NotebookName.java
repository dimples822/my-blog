package com.site.blog.my.core.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class NotebookName implements Serializable {
    /**
    * 主键
    */
    private Long id;

    /**
    * 笔记本分类
    */
    private Integer notebookName;

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