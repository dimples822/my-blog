package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.NotebookName;

public interface NotebookNameService {


    int deleteByPrimaryKey(Long id);

    int insert(NotebookName record);

    int insertSelective(NotebookName record);

    NotebookName selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotebookName record);

    int updateByPrimaryKey(NotebookName record);

    /**
     * 查询所有笔记本
     *
     * @return NotebookName
     */
    NotebookName selectAll();
}
