package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.entity.NoteDetail;
import com.site.blog.my.core.mapper.NoteDetailMapper;
import com.site.blog.my.core.service.NoteDetailService;
import com.site.blog.my.core.util.MarkDownUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        NoteDetail noteDetail = noteDetailMapper.selectByPrimaryKey(id);
        String noteContent = noteDetail.getNoteContent();
        noteDetail.setNoteContent(MarkDownUtil.mdToHtml(noteContent));
        return noteDetail;
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
