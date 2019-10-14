package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.NoteDetail;
public interface NoteDetailService{


    int deleteByPrimaryKey(Long id);

    int insert(NoteDetail record);

    int insertSelective(NoteDetail record);

    NoteDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteDetail record);

    int updateByPrimaryKey(NoteDetail record);

}
