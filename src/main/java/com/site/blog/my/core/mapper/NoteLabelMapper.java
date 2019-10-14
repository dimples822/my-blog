package com.site.blog.my.core.mapper;

import com.site.blog.my.core.entity.NoteLabel;

public interface NoteLabelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteLabel record);

    int insertSelective(NoteLabel record);

    NoteLabel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteLabel record);

    int updateByPrimaryKey(NoteLabel record);
}