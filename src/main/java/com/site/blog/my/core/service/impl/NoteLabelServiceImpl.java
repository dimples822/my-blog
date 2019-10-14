package com.site.blog.my.core.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.site.blog.my.core.mapper.NoteLabelMapper;
import com.site.blog.my.core.entity.NoteLabel;
import com.site.blog.my.core.service.NoteLabelService;
@Service
public class NoteLabelServiceImpl implements NoteLabelService{

    @Resource
    private NoteLabelMapper noteLabelMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return noteLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(NoteLabel record) {
        return noteLabelMapper.insert(record);
    }

    @Override
    public int insertSelective(NoteLabel record) {
        return noteLabelMapper.insertSelective(record);
    }

    @Override
    public NoteLabel selectByPrimaryKey(Long id) {
        return noteLabelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NoteLabel record) {
        return noteLabelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NoteLabel record) {
        return noteLabelMapper.updateByPrimaryKey(record);
    }

}
