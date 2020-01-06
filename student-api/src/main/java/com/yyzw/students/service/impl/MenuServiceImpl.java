package com.yyzw.students.service.impl;

import com.yyzw.students.entity.MenuVo;
import com.yyzw.students.mapper.MenuMapper;
import com.yyzw.students.service.MenuService;
import com.yyzw.students.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Override
    public List<MenuVo> getMenuList() {
        List<MenuVo> selectAll = this.menuMapper.selectAll();
        return TreeUtils.listToTree(selectAll,1);
    }
}
