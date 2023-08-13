<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户id" prop="uid">
        <el-input v-model="queryParams.uid" placeholder="请输入用户id" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="图片地址" prop="imgurl">
        <el-input v-model="queryParams.imgurl" placeholder="请输入图片地址" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="视频地址" prop="videourl">
        <el-input v-model="queryParams.videourl" placeholder="请输入视频地址" clearable size="small"
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="逻辑删除" prop="deleted">
        <el-select v-model="queryParams.deleted" placeholder="请选择逻辑删除" clearable size="small">
          <el-option v-for="dict in deletedOptions" :key="dict.dictValue" :label="dict.dictLabel"
            :value="dict.dictValue==='1'" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['citylife:userFile:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['citylife:userFile:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['citylife:userFile:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['citylife:userFile:export']">导出</el-button>
      </el-col>
      <div class="top-right-btn">
        <el-tooltip class="item" effect="dark" content="刷新" placement="top">
          <el-button size="mini" circle icon="el-icon-refresh" @click="handleQuery" />
        </el-tooltip>
        <el-tooltip class="item" effect="dark" :content="showSearch ? '隐藏搜索' : '显示搜索'" placement="top">
          <el-button size="mini" circle icon="el-icon-search" @click="showSearch=!showSearch" />
        </el-tooltip>
      </div>
    </el-row>

    <el-table v-loading="loading" :data="userFileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="文件id" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="uid" />
      <el-table-column label="图片地址" align="center">
        <template slot-scope="scope">
          <el-image :src="scope.row.imgurl" style="width: 50px;height: 50px" fit="cover" />
        </template>
      </el-table-column>
      <el-table-column label="视频地址" align="center" prop="videourl" />
      <el-table-column label="逻辑删除" align="center" prop="deleted" :formatter="deletedFormat" />
      <el-table-column label="操作" fixed="right" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['citylife:userFile:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['citylife:userFile:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改文件上传对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="uid">
          <el-input v-model="form.uid" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="图片地址" prop="imgurl">
          <el-input v-model="form.imgurl" placeholder="请输入图片地址" />
        </el-form-item>
        <el-form-item label="视频地址" prop="videourl">
          <el-input v-model="form.videourl" placeholder="请输入视频地址" />
        </el-form-item>
        <el-form-item label="逻辑删除">
          <el-select v-model="form.deleted" placeholder="请选择逻辑删除">
            <el-option v-for="dict in deletedOptions" :key="dict.dictValue" :label="dict.dictLabel"
              :value="dict.dictValue==='1'"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listUserFile,
    getUserFile,
    delUserFile,
    addUserFile,
    updateUserFile,
    exportUserFile
  } from "@/api/citylife/userFile";

  export default {
    name: "UserFile",
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 文件上传表格数据
        userFileList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 逻辑删除字典
        deletedOptions: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          uid: null,
          imgurl: null,
          videourl: null,
          deleted: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          uid: [{
            required: true,
            message: "用户id不能为空",
            trigger: "blur"
          }],
        }
      };
    },
    created() {
      this.getList();
      this.getDicts("sys_logic").then(response => {
        this.deletedOptions = response.data;
      });
    },
    methods: {
      /** 查询文件上传列表 */
      getList() {
        this.loading = true;
        listUserFile(this.queryParams).then(response => {
          this.userFileList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 逻辑删除字典翻译
      deletedFormat(row, column) {
        return row.deleted ? '是' : '否';
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          id: null,
          uid: null,
          imgurl: null,
          videourl: null,
          deleted: null,
          createTime: null,
          updateTime: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加文件上传";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getUserFile(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改文件上传";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateUserFile(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                }
              });
            } else {
              addUserFile(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("新增成功");
                  this.open = false;
                  this.getList();
                }
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除文件上传编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUserFile(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有文件上传数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportUserFile(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
      }
    }
  };
</script>
