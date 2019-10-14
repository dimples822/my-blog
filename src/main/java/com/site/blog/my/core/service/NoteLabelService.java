package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.NoteLabel;
public interface NoteLabelService{


    int deleteByPrimaryKey(Long id);

    int insert(NoteLabel record);

    int insertSelective(NoteLabel record);

    NoteLabel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteLabel record);

    int updateByPrimaryKey(NoteLabel record);

}
