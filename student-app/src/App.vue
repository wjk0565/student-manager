<template>
  <div id="app">
    <el-container>
    <el-aside>
      <v-menu></v-menu>
    </el-aside>
      <el-container>
        <el-header>
          <template>
            <div>
              <h2>XX管理系统</h2>
            </div>
          </template>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>

  </el-container>
  </div>
</template>

<script>
  import  Menu from '@/components/Menu'
export default {
  name: 'App',
  components:{
    'v-menu':Menu
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
