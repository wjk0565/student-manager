package com.yyzw.students.entity;

import lombok.Data;

@Data
public class ResultVo {

    private boolean status;

    private String msg;

    private Object result;


    public ResultVo(boolean status, String msg, Object result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public ResultVo(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultVo() {
    }
}
