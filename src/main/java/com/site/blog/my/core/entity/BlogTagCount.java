package com.site.blog.my.core.entity;

import lombok.Data;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/8/22
  */
@Data
public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private Integer tagCount;

}
