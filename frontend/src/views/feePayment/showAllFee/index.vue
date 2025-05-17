<template>
    <div class="fee-container">
        <div class="search-area">
            <el-input
                    v-model="searchId"
                    placeholder="请输入要查询的学生ID"
                    class="search-input"
                    @keyup.enter="searchFee"
            />
            <el-button
                    class="search-btn"
                    type="primary"
                    @click="searchFee"
            >
                搜索
            </el-button>
        </div>

        <div class="table-area">
            <div ref="tableWrapper" class="table-wrapper">
                <el-table
                        :data="feeList"
                        border
                        fit
                        :highlight-current-row="highlightId"
                        style="width: 100%"
                >
                    <el-table-column prop="stuId" label="学生ID" />
                    <el-table-column prop="stuName" label="学生姓名" />
                    <el-table-column prop="className" label="学生班级" />
                    <el-table-column prop="fee" label="应缴费用" />
                    <el-table-column prop="dormitory" label="宿舍号" />
                </el-table>
            </div>
        </div>

        <div v-if="loading" class="loading-indicator">加载中...</div>
    </div>
</template>

<script>
import { getAllFees } from '@/api/Fee'
export default {
    data() {
        return {
            feeList: [],
            loading: false,
            allFetched: false,
            searchId: '',
            highlightId: null
        }
    },
    created() {
        this.fetchFees()
    },
    methods: {
        fetchFees() {
            if (this.loading || this.allFetched) {
                return
            }

            this.loading = true
            getAllFees().then(response => {
                if (response && response.data) {
                    if (Array.isArray(response.data)) {
                        this.feeList = response.data
                        if (response.data.length < 10) {
                            this.allFetched = true
                        }
                    } else {
                        this.feeList = [response.data]
                    }
                } else {
                    this.feeList = []
                    this.$message.warning('未找到费用信息')
                }
                this.loading = false
            }).catch(() => {
                this.$message.error('获取费用信息失败')
                this.loading = false
            })
        },
        handleScroll() {
            const { scrollTop, scrollHeight, clientHeight } = this.$refs.tableWrapper
            if (scrollTop + clientHeight >= scrollHeight) {
                this.fetchFees()
            }
        },
        searchFee() {
            const foundIndex = this.feeList.findIndex(item => item.stuId === this.searchId)
            if (foundIndex !== -1) {
                this.highlightId = this.feeList[foundIndex].stuId
                const rowHeight = 50
                const scrollTop = foundIndex * rowHeight
                this.$refs.tableWrapper.scrollTop = scrollTop
            } else {
                this.$message.warning('未找到相关费用信息')
            }
        }
    }
}
</script>

<style scoped>
.fee-container {
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.search-area {
    display: flex;
    align-items: center;
    justify-content: flex-end; /* Align items to the right */
    margin-bottom: 20px;
    gap: 10px;
}

.search-input {
    width: 300px;
}

.search-btn {
    margin-left: 10px;
}

.table-area {
    border: 1px solid #ebeef5;
    border-radius: 4px;
    overflow: hidden;
}

.table-wrapper {
    height: 500px;
    overflow-y: auto;
}

.loading-indicator {
    text-align: center;
    padding: 10px;
    color: #909399;
    font-size: 14px;
}
</style>

