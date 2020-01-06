<template>
    <div id="menu">
      <el-menu class='el-menu-vertical-demo' :router='true' v-for='(item, index) in navMenu' :key='index'>
        <!--@mouseover.native="overShow" @mouseout.native="outHide"-->
        <el-submenu v-if='item.childs' :index='item.menuUrl' :route = 'item.menuUrl'>
          <template slot='title'>
            <i :class='item.icon'></i>
            <span slot='title'>{{item.menuName}}</span>
            <i class='iconfont icon-shenpi edit' v-show='haha'></i>
          </template>
          <el-submenu v-if='item1.childs' v-for= '(item1, index) in item.childs' :key='item1.menuUrl' :index='item1.menuUrl' :route='item1.menuUrl'>
            <template slot='title'>
              <i :class='item1.icon'></i>
              <span slot='title'>{{item1.menuName}}</span>
            </template>
            <el-submenu v-for= '(item2, index) in item1.childs' :key='item2.menuUrl' v-if='item2.childs' :index='item2.menuUrl' :route = 'item2.menuUrl'>
              <template slot='title'>
                <i :class='item2.icon'></i>
                <span slot='title'>{{item2.menuName}}</span>
              </template>
              <el-submenu v-for= '(item3, index) in item2.childs' :key='item3.menuUrl' v-if='item3.childs' ::index='item3.menuUrl' :route = 'item3.menuUrl'>
                <template slot='title'>
                  <i :class='item3.icon'></i>
                  <span slot='title'>{{item3.menuName}}</span>
                </template>
                <el-menu-item v-for= '(item4, index) in item3.childs' :key='item3.menuUrl' v-if='item4.childs == null' :index='item4.menuUrl' :route = 'item4.menuUrl'>
                  <span>{{item4.menuName}}</span>
                </el-menu-item>
              </el-submenu>
              <el-menu-item v-for= '(item3, index) in item2.childs' :key='item3.menuUrl' v-if='item3.childs == null' :index='item3.menuUrl' :route = 'item3.menuUrl'>
                <span>{{item3.menuName}}</span>
              </el-menu-item>
            </el-submenu>
            <el-menu-item v-for= '(item2, index) in item1.childs' :key='item2.menuUrl' v-if='item2.childs == null' :index='item2.menuUrl' :route = 'item2.menuUrl'>
              <span>{{item2.menuName}}</span>
            </el-menu-item>
          </el-submenu>
          <el-menu-item v-for= '(item1, index) in item.childs' :key='item1.menuUrl' v-if='item1.childs == null' :index='item1.menuUrl' :route = 'item1.menuUrl'>
            <span>{{item1.menuName}}</span>
          </el-menu-item>
        </el-submenu>
        <el-menu-item v-if='item.childs == null' :index='item.menuUrl' :route = 'item.menuUrl'>
          <i :class='item.iconName'></i>
          <span slot='title'>{{item.menuName}}</span>
        </el-menu-item>
      </el-menu>

     <!-- <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
        <el-radio-button :label="false">展开</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">导航一</span>
          </template>
          <el-menu-item-group>
            <span slot="title">分组一</span>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <span slot="title">选项4</span>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">导航二</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <i class="el-icon-document"></i>
          <span slot="title">导航三</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
      </el-menu>-->



    </div>
</template>

<script>
    export default {
        name: "Menu",
        data(){
          return {
            isCollapse:true,
            navMenu:[]
          }
        },
        methods: {
          getMenuList(){
             const  url = 'menu/list';
             this.http.get(url).then(res => {
               if (res.status) {
                 this.navMenu = res.result;
               }
             });
             this.navMenu
          }
        },
      mounted(){
          this.getMenuList();
      }
    }
</script>

<style scoped>

  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }


</style>
