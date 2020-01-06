package com.yyzw.students.utils;

import com.yyzw.students.entity.MenuVo;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {
    //将list集合转成树形结构的list集合
    public static List<MenuVo> listToTree(List<MenuVo> list,int rootId) {
        //用递归找子。
        List<MenuVo> treeList = new ArrayList<MenuVo>();
        for (MenuVo tree : list) {
            if (tree.getPid()==rootId) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    //寻找子节点
    private static MenuVo findChildren(MenuVo tree, List<MenuVo> list) {
        for (MenuVo node : list) {
            if (node.getPid()==tree.getId()) {
                if (tree.getChilds() == null) {
                    tree.setChilds(new ArrayList<MenuVo>());
                }
                tree.getChilds().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
