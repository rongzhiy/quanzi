<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户id" prop="uid">
        <el-input
          v-model="queryParams.uid"
          placeholder="请输入用户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回答id" prop="answerid">
        <el-input
          v-model="queryParams.answerid"
          placeholder="请输入回答id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论id" prop="detail">
        <el-input
          v-model="queryParams.detail"
          placeholder="请输入评论id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞数" prop="likes">
        <el-input
          v-model="queryParams.likes"
          placeholder="请输入点赞数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点踩数" prop="unlikes">
        <el-input
          v-model="queryParams.unlikes"
          placeholder="请输入点踩数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核与否" prop="checked">
        <el-select v-model="queryParams.checked" placeholder="请选择审核与否" clearable size="small">
          <el-option
            v-for="dict in checkedOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue==='1'"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="逻辑删除" prop="deleted">
        <el-select v-model="queryParams.deleted" placeholder="请选择逻辑删除" clearable size="small">
          <el-option
            v-for="dict in deletedOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue==='1'"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['citylife:comments:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['citylife:comments:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['citylife:comments:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['citylife:comments:export']"
        >导出</el-button>
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

    <el-table v-loading="loading" :data="commentsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="评论id" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="uid" />
      <el-table-column label="回答id" align="center" prop="answerid" />
      <el-table-column label="评论详情" align="center">
        <template slot-scope="scope">
                 <span style="display: -webkit-box;
              					-webkit-line-clamp: 3;
              					-webkit-box-orient: vertical;
              					overflow: hidden;">{{scope.row.detail}}</span>
               </template>
        </el-table-column>
      <el-table-column label="点赞数" align="center" prop="likes" />
      <el-table-column label="点踩数" align="center" prop="unlikes" />
      <el-table-column label="审核与否" align="center" prop="checked" :formatter="checkedFormat" />
      <el-table-column label="逻辑删除" align="center" prop="deleted" :formatter="deletedFormat" />
      <el-table-column label="操作" fixed="right" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['citylife:comments:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['citylife:comments:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改评论对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="uid">
          <el-input v-model="form.uid" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="回答id" prop="answerid">
          <el-input v-model="form.answerid" placeholder="请输入回答id" />
        </el-form-item>
        <el-form-item label="评论id" prop="detail">
          <el-input v-model="form.detail" placeholder="请输入评论id" />
        </el-form-item>
        <el-form-item label="点赞数" prop="likes">
          <el-input v-model="form.likes" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="点踩数" prop="unlikes">
          <el-input v-model="form.unlikes" placeholder="请输入点踩数" />
        </el-form-item>
        <el-form-item label="审核与否">
          <el-select v-model="form.checked" placeholder="请选择审核与否">
            <el-option
              v-for="dict in checkedOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue==='1'"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="逻辑删除">
          <el-select v-model="form.deleted" placeholder="请选择逻辑删除">
            <el-option
              v-for="dict in deletedOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue==='1'"
            ></el-option>
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
import { listComments, getComments, delComments, addComments, updateComments, exportComments } from "@/api/citylife/comments";

export default {
  name: "Comments",
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
      // 评论表格数据
      commentsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 审核与否字典
      checkedOptions: [],
      // 逻辑删除字典
      deletedOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uid: null,
        answerid: null,
        detail: null,
        likes: null,
        unlikes: null,
        checked: null,
        deleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        answerid: [
          { required: true, message: "回答id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_logic").then(response => {
      this.checkedOptions = response.data;
    });
    this.getDicts("sys_logic").then(response => {
      this.deletedOptions = response.data;
    });
  },
  methods: {
    /** 查询评论列表 */
    getList() {
      this.loading = true;
      listComments(this.queryParams).then(response => {
        this.commentsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 审核与否字典翻译
    checkedFormat(row, column) {
      return row.checked? '是':'否';
    },
    // 逻辑删除字典翻译
    deletedFormat(row, column) {
      return row.deleted? '是':'否';
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
        answerid: null,
        detail: null,
        likes: null,
        unlikes: null,
        checked: null,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加评论";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getComments(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改评论";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComments(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addComments(this.form).then(response => {
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
      this.$confirm('是否确认删除评论编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delComments(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有评论数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportComments(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
