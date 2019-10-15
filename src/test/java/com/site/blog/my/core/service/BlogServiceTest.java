package com.site.blog.my.core.service;

import com.site.blog.my.core.controller.vo.BlogDetailVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void getBlogDetail() {
        BlogDetailVO blogDetail = blogService.getBlogDetail(5L);
        log.info(String.valueOf(blogDetail));
    }
}

























