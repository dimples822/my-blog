package com.site.blog.my.core.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.site.blog.my.core.mapper.NoteDetailMapper;
import com.site.blog.my.core.entity.NoteDetail;
import com.site.blog.my.core.service.NoteDetailService;
@Service
public class NoteDetailServiceImpl implements NoteDetailService{

    @Resource
    private NoteDetailMapper noteDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return noteDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(NoteDetail record) {
        return noteDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(NoteDetail record) {
        return noteDetailMapper.insertSelective(record);
    }

    @Override
    public NoteDetail selectByPrimaryKey(Long id) {
        return noteDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NoteDetail record) {
        return noteDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NoteDetail record) {
        return noteDetailMapper.updateByPrimaryKey(record);
    }

}
