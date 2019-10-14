package com.site.blog.my.core.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.site.blog.my.core.mapper.NotebookNameMapper;
import com.site.blog.my.core.entity.NotebookName;
import com.site.blog.my.core.service.NotebookNameService;
@Service
public class NotebookNameServiceImpl implements NotebookNameService{

    @Resource
    private NotebookNameMapper notebookNameMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return notebookNameMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(NotebookName record) {
        return notebookNameMapper.insert(record);
    }

    @Override
    public int insertSelective(NotebookName record) {
        return notebookNameMapper.insertSelective(record);
    }

    @Override
    public NotebookName selectByPrimaryKey(Long id) {
        return notebookNameMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NotebookName record) {
        return notebookNameMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NotebookName record) {
        return notebookNameMapper.updateByPrimaryKey(record);
    }

}
