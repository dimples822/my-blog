package com.site.blog.my.core.entity;

import lombok.Data;

/**
 * <br>后台管理用户</br>
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/22
 */
@Data
public class AdminUser {
    private Integer adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;


}