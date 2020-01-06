<template>
  <div>
    <el-row  >
      <el-col :span="24" >
        <el-col :span="24" class="toolbar">
          <el-form :inline="true" :model="filters">
            <el-form-item>
              用户名：
            </el-form-item>
            <el-form-item>
              <el-input v-model="filters.userName" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="getUser">搜索</el-button>
            </el-form-item>
            <el-button type="primary" @click="showAddUserDiag(true)" style="margin-bottom: 10px;">添加用户</el-button>
          </el-form>
        </el-col>
      </el-col>

      <div class="my-el-table">
        <el-table :data="data" size="mini"
                  border style="width:100%" v-loading="listLoading">
          <el-table-column prop="id" label="主键" v-if="false"></el-table-column>
          <el-table-column prop="userName" label="用户名"></el-table-column>
          <el-table-column prop="userCode" label="账号" width="300"></el-table-column>
          <el-table-column prop="remark" label="备注"></el-table-column>
          <el-table-column  label="状态">
            <template scope="scope">
              <el-tag v-if="scope.row.status == 0" type="danger">不可用</el-tag>
              <el-tag v-if="scope.row.status == 1" type="primary">可用</el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template scope="scope">
              <el-button size="small"  type="primary" @click="lookUser(scope.row)">查看</el-button>
              <el-button size="small"  type="primary" @click="delUser(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-col :span="24" class="toolbar block">
          <el-pagination layout="total,prev,pager,next"  @current-change="handleCurrentChange" :page-size="15" :total="total"></el-pagination>
        </el-col>
      </div>

    </el-row>
      <el-dialog title="添加用户" :visible.sync="dialogFormVisible">
        <el-form ref="userForm" :model="userForm" :rules="rules">
          <el-form-item label="主键" prop="id" label-width="100px" v-if="false">
            <el-input v-model="userForm.id" ></el-input>
          </el-form-item>
          <el-form-item label="用户名" prop="userName" label-width="100px">
            <el-input v-model="userForm.userName" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="账号" prop="userCode"   label-width="100px">
            <el-input v-model="userForm.userCode" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码"  prop="password"  label-width="100px">
            <el-input v-model="userForm.password"></el-input>
          </el-form-item>
          <el-form-item label="备注"   prop="remark"  label-width="100px">
            <el-input v-model="userForm.remark"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="showAddUserDiag(false)">取 消</el-button>
          <el-button type="primary" @click="addUserOption('userForm')">确 定</el-button>
        </div>
      </el-dialog>
  </div>


</template>

<script>
  import * as Message from "element-ui";

  export default {
    data() {
      return {
        filters:{
          userName:''
        },
        total:0,
        pageNum:1,
        dialogFormVisible: false,
        listLoading: false,
        selectIndex: null,
        data:[],
        userForm: {
          userName: '',
          userCode: '',
          password: '',
          remark:'',
        },
        rules: {
          userName: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          userCode: [
            {required: true, message: '请输入账号', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          remark: [
            {required: true, message: '请输入备注', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ]
        }
      }
    },
    mounted() {
//初始化
      //this.typeInfo(); //分类初始化
      this.userInfo(); //用户初始化列表
    },
    methods: {
      getUser () {
        this.userInfo();
      },
      //下拉框初始化

      //用户数据初始化
      userInfo () {
        this.listLoading = true;
        let url = 'user/list?userName=' + this.filters.userName + '&pageNum=' + this.pageNum;
//通过接口调用数据
        this.http.get(url).then(res => {
          if (res.code == 200) {
            this.data = res.data.list;
            this.total = res.count;
            this.listLoading = false;
          }
        });
      },
      //查看用户信息
      delUser (row) {
        debugger;
        if (row !== undefined) {
          const  url ="user/delUser?id="+row.id
          this.http.get(url).then(res=>{
            if(res.status){
              this.userInfo()
            }
          })
        }
      },
      lookUser(row){
        if (row !== undefined) {
          const  url ="user/getUser?id="+row.id
          this.http.get(url).then(res=>{
            if(res.status){
              debugger;
              this.showAddUserDiag(true);
              this.userForm=res.result;
            }
          })
        }
      },
      //点击分页
      handleCurrentChange (val) {
        this.pageNum = val;
        this.userInfo();
      },
      showAddUserDiag(flag){
        console.log(this.dialogFormVisible);
         this.dialogFormVisible=flag;
        console.log(this.dialogFormVisible);
      },
      addUserOption(formName){
        let that = this
        this.$refs[formName].validate((valid)=>{
          if(valid){
            this.http.postForm('user/addUser',that.userForm).then(res=>{
              debugger
              if(res.status){
                this.dialogFormVisible=false;
                this.userInfo();
              }
            })
          }
        })
      }
    }
  }
</script>

<style></style>
