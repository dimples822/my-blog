package com.site.blog.my.core.util;

import java.io.Serializable;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/22
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 4746940453384732962L;
    private int resultCode;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

}
