package com.site.blog.my.core.controller.blog;

import com.site.blog.my.core.entity.NotebookName;
import com.site.blog.my.core.util.Result;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyBlogControllerTest {

    @Autowired
    private MyBlogController myBlogController;

    @Test
    public void saveNotebookName() {
        NotebookName notebookName = new NotebookName();
        notebookName.setNotebookName("Web前端");
        Result result = myBlogController.saveNotebookName(notebookName);
        log.debug(result.getMessage());
    }
}


















