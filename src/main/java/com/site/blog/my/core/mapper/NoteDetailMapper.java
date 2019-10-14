package com.site.blog.my.core.mapper;

import com.site.blog.my.core.entity.NoteDetail;

public interface NoteDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteDetail record);

    int insertSelective(NoteDetail record);

    NoteDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteDetail record);

    int updateByPrimaryKey(NoteDetail record);
}