package com.site.blog.my.core.entity;

import java.util.Date;

import lombok.Data;

/**
 * 配置</br>
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/22
 */
@Data
public class BlogConfig {
    private String configName;

    private String configValue;

    private Date createTime;

    private Date updateTime;

}