package com.yyzw.students.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="STUDENT_USER")
public class SysUserVo {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_CODE")
    private String userCode;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="REMARK")
    private String remark;

    @Column(name="STATUS")
    private String status;
    @Column(name="CREATE_BY")
    private String createBy;
    @Column(name="UPDATE_BY")
    private String updateBy;
    @Column(name="CREATE_TIME")
    private Date createTime;

    @Column(name="UPDATE_TIME")
    private Date updateTime;
}
