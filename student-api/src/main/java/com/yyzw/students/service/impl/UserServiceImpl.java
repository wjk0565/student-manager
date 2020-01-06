package com.yyzw.students.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyzw.students.entity.SysUserVo;
import com.yyzw.students.mapper.UserMapper;
import com.yyzw.students.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public PageInfo<SysUserVo> getUserLists(String pageNum, String userName) throws Exception {
        PageHelper.startPage(Integer.valueOf(pageNum),15);
        Example example =new Example(SysUserVo.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(userName)){
            criteria.andLike("userName",userName);
        }
        List<SysUserVo> sysUserVos = userMapper.selectByExample(example);
        PageInfo<SysUserVo> pageInfo = new PageInfo<SysUserVo>(sysUserVos);
        return pageInfo;
    }

    @Override
    public void addUserVo(SysUserVo sysUserVo) throws Exception {
        sysUserVo.setCreateBy("admin");
        sysUserVo.setCreateTime(new Date());
        sysUserVo.setStatus("1");
        this.userMapper.insertSelective(sysUserVo);
    }

    @Override
    public void delUser(String id) throws Exception {
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setId(Integer.parseInt(id));
        this.userMapper.deleteByPrimaryKey(sysUserVo);

    }

    @Override
    public SysUserVo getUserById(String id) throws Exception {
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setId(Integer.parseInt(id));
        return this.userMapper.selectByPrimaryKey(sysUserVo);
    }
}
