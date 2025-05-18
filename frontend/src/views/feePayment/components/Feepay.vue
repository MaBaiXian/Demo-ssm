<template>
  <div>
    <el-table v-if="feeList.length > 0" :data="feeList" border fit highlight-current-row style="width: 100%">
      <el-table-column prop="stuId" label="学生ID" align="center" />
      <el-table-column prop="stuName" label="学生姓名" align="center" />
      <el-table-column prop="className" label="学生班级" align="center" />
      <el-table-column prop="fee" label="应缴费用" align="center" :formatter="formatFee" />
      <el-table-column prop="dormitory" label="宿舍号" align="center" />
      <el-table-column label="操作" align="center">
        <template v-slot="scope">
          <el-button type="primary" size="small" @click="showPayDialog(scope.row)">缴费</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div v-else class="no-data">暂无费用信息</div>

    <!-- 缴费确认对话框 -->
    <el-dialog
      :visible.sync="payDialogVisible"
      title="缴费确认"
      width="30%"
      :modal="true"
      :close-on-click-modal="false"
    >
      <span>确认要为 {{ currentStudent.stuName }} (学号: {{ currentStudent.stuId }}) 缴纳 {{ currentStudent.fee }} 元费用吗？</span>
      <template v-slot:footer>
        <div class="dialog-footer">
          <el-button @click="payDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="payDialogVisible = false;handleConfirmPayment()">确认缴费</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { getFeeByStudentId } from '@/api/Fee'
import { deleteFee } from '@/api/Fee'
export default {
  data() {
    return {
      feeList: [],
      loading: false,
      payDialogVisible: false,
      currentStudent: {
        stuId: '',
        stuName: '',
        fee: 0
      }
    }
  },
  created() {
    this.fetchCurrentUserFee()
  },
  methods: {
    async handleConfirmPayment() {
      const userId = this.$store.state.user.stuId
      if (this.loading) return
      if (!userId) {
        this.$message.error('请先登录！')
        return
      }

      this.loading = true
      try {
        await deleteFee(userId)
        this.$message.success('缴费成功！')
        setTimeout(() => {
          window.location.reload()
        }, 1000) // 1秒后刷新，让用户能看到成功提示
      } catch (error) {
        this.$message.error(`缴费失败: ${error.response?.data?.message || error.message}`)
      } finally {
        this.loading = false
      }
    },
    fetchCurrentUserFee() {
      const userId = this.$store.state.user.stuId
      if (!userId) {
        this.$message.error('无法获取当前用户信息')
        return
      }

      this.loading = true
      getFeeByStudentId(userId).then(response => {
        if (response && response.data) {
          this.feeList = Array.isArray(response.data) ? response.data : [response.data]
        } else {
          this.feeList = []
          this.$message.warning('未找到相关费用信息')
        }
        this.loading = false
      }).catch(() => {
        this.$message.warning('未找到相关费用信息')
        this.loading = false
      })
    },
    // formatFee(row, column, cellValue) {
    //   return parseFloat(cellValue || 0).toFixed(2)
    // },
    showPayDialog(row) {
      // console.log('hhhhhhhhh')
      // console.log('showPayDialog called', row)
      this.currentStudent = {
        stuId: row.stuId,
        stuName: row.stuName,
        fee: row.fee
      }
      this.payDialogVisible = true
      // console.log('aaaaaaaa')
      // console.log('payDialogVisible:', this.payDialogVisible)
    }
  }
}
</script>

<style scoped>
.el-table {
    width: 100%;
}
.no-data {
    color: #999;
    text-align: center;
    margin-top: 10px;
}
.dialog-footer {
    display: flex;
    justify-content: flex-end;
}
</style>
