package com.site.blog.my.core.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class NoteDetail implements Serializable {
    /**
    * 主键
    */
    private Long id;

    /**
    * 笔记本名称
    */
    private Integer notebookName;

    /**
    * 笔记名称
    */
    private String noteName;

    /**
    * 笔记描述
    */
    private String noteDesc;

    /**
    * 笔记内容
    */
    private String noteContent;

    /**
    * 图片路径
    */
    private String imgUrl;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 笔记分类
    */
    private Integer noteLabel;

    private static final long serialVersionUID = 1L;
}