package com.site.blog.my.core.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 笔记本列表
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/10/14
 */
@Data
public class NotebookName implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 笔记本分类
     */
    private String notebookName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 笔记数量
     */
    private Integer count;

    private static final long serialVersionUID = 1L;
}