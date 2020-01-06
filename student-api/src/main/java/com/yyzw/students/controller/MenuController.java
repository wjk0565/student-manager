package com.yyzw.students.controller;

import com.yyzw.students.entity.MenuVo;
import com.yyzw.students.entity.ResultVo;
import com.yyzw.students.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends  BaseController{

    @Autowired
    private MenuService menuService;


    @ResponseBody
    @RequestMapping("/list")
    public ResultVo getMenuList(HttpServletRequest request){
        List<MenuVo> menuList =null;
        try {
            menuList = menuService.getMenuList();
        } catch (Exception e) {
           logger.error("获取菜单信息异常：{}",e.getMessage(),e);
           return new ResultVo(false,e.getMessage());
        }
       return new ResultVo(true,"加载成功",menuList);
    }

}
