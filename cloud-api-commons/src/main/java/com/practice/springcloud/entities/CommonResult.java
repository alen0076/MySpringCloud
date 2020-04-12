package com.practice.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alen0076
 * @date 2020/4/11_12:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code, message, null);
    }
}
