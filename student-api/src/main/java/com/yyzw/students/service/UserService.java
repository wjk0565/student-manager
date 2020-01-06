package com.yyzw.students.service;

import com.github.pagehelper.PageInfo;
import com.yyzw.students.entity.SysUserVo;

public interface UserService {

    PageInfo<SysUserVo> getUserLists(String pageNum, String userName) throws Exception;

    void addUserVo(SysUserVo sysUserVo) throws Exception;

    void delUser(String id) throws Exception;

    SysUserVo getUserById(String id) throws Exception;
}
