package com.yyzw.students.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name ="SYS_MENU")
public class MenuVo {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="PID")
    private int pid;

    @Column(name="MENU_NAME")
    private String menuName;

    @Column(name="MENU_URL")
    private String menuUrl;

    @Column(name="ICON_NAME")
    private String iconName;

    @Column(name="MENU_LEVELS")
    private String menuLevels;

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

    @Transient
    private List<MenuVo> childs;
}
