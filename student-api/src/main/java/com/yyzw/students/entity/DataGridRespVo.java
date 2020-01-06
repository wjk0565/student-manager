package com.yyzw.students.entity;

import lombok.Data;

@Data
public class DataGridRespVo<T> {
    private String code;

    private String msg;

    private Long count;

    private T data;
}
