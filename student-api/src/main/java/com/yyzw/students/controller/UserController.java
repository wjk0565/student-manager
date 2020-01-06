package com.yyzw.students.controller;

import com.github.pagehelper.PageInfo;
import com.yyzw.students.entity.DataGridRespVo;
import com.yyzw.students.entity.ResultVo;
import com.yyzw.students.entity.SysUserVo;
import com.yyzw.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends  BaseController{


    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("list")
    public DataGridRespVo<SysUserVo> getUserLists(String pageNum, String userName,
                                                  HttpServletRequest request){
        DataGridRespVo gridRespVo =null;
        try {
            PageInfo<SysUserVo> list = userService.getUserLists(pageNum,userName);
            gridRespVo = new  DataGridRespVo<SysUserVo>();
            gridRespVo.setCode("200");
            gridRespVo.setData(list);
            gridRespVo.setCount(list.getTotal());
        } catch (Exception e) {
            logger.error("查询异常{}",e.getMessage(),e);
        }
        return gridRespVo;
    }


    @ResponseBody
    @RequestMapping("addUser")
    public ResultVo addUserVo(SysUserVo sysUserVo, HttpServletRequest request) throws Exception{
        try {
            userService.addUserVo(sysUserVo);
        } catch (Exception e) {
            logger.error("增加用户异常{}",e.getMessage(),e);
            return new ResultVo(false,e.getMessage());
        }
        return new ResultVo(true,"增加成功");
    }


    @ResponseBody
    @RequestMapping("delUser")
    public ResultVo delUser(String id,HttpServletRequest request) throws Exception{
        try {
            userService.delUser(id);
        } catch (Exception e) {
            logger.error("删除用户异常{}",e.getMessage(),e);
            return new ResultVo(false,e.getMessage());
        }
        return new ResultVo(true,"删除成功");
    }

    @ResponseBody
    @RequestMapping("getUser")
    public ResultVo getUser(String id,HttpServletRequest request) throws Exception{
        SysUserVo sysUserVo =null;
        try {
            sysUserVo = userService.getUserById(id);
        } catch (Exception e) {
            logger.error("获取用户成功异常{}",e.getMessage(),e);
            return new ResultVo(false,e.getMessage());
        }
        return new ResultVo(true,"获取用户成功",sysUserVo);
    }

}
