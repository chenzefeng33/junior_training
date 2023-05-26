<template>
  <div>
    <div>
      <el-button
          type="primary"
          @click="dialogCreateUserVisible = true"
          plain>
        创建发货人账户
      </el-button>

      <el-dialog title="创建发货人账户" :visible.sync="dialogCreateUserVisible">
        <el-form :model="UserForm" :rules="Userrules" ref="UserForm">
          <el-form-item label="账户名称" :label-width="formLabelWidth" prop="shipper">
            <el-input v-model="UserForm.shipper" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="描述" :label-width="formLabelWidth" prop="description">
            <el-input v-model="UserForm.description" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="账户区域" :label-width="formLabelWidth" prop="account_region">
            <el-input v-model="UserForm.account_region" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="联系方式" :label-width="formLabelWidth" prop="account_number">
            <el-input v-model="UserForm.account_number" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="收件地址" :label-width="formLabelWidth" prop="shipping_address">
            <el-input v-model="UserForm.shipping_address" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogCreateUserVisible = false">取 消</el-button>
          <el-button type="primary" @click="CreateUserSubmit">确 定</el-button>
        </div>
      </el-dialog>
    </div>

<!--    样式代码-->
    <div style="height: 20px"></div>

    <div>
      <el-button
          type="primary"
          @click="dialogCreateOrderVisible = true"
          plain>
        创建发货订单
      </el-button>

      <el-dialog title="创建发货订单" :visible.sync="dialogCreateOrderVisible">
        <el-form :model="OrderForm" :rules="Orderrules" ref="OrderForm">
          <el-form-item label="订单状态" :label-width="formLabelWidth" prop="order_status">
            <el-input v-model="OrderForm.order_status" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="收件地址" :label-width="formLabelWidth" prop="shipping_address">
            <el-input v-model="OrderForm.shipping_address" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="寄件地址" :label-width="formLabelWidth" prop="delivery_address">
            <el-input v-model="OrderForm.delivery_address" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="托运人" :label-width="formLabelWidth" prop="shipper">
            <el-input v-model="OrderForm.shipper" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
          <el-form-item label="收件人" :label-width="formLabelWidth" prop="receiver">
            <el-input v-model="OrderForm.receiver" autocomplete="off" placeholder="请输入内容"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogCreateOrderVisible = false">取 消</el-button>
          <el-button type="primary" @click="CreateOrderSubmit">确 定</el-button>
        </div>
      </el-dialog>
    </div>

    <!--    样式代码-->
    <div style="height: 20px"></div>

    <div>
      <el-form :inline="true" :model="SearchBillsForm">
        <el-form-item>
          <el-input v-model="SearchBillsForm.name" placeholder="请输入姓名">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="SearchBillsSubmit">查询</el-button>
          <el-button type="primary" @click="getList">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table
          :data="tableData"
          stripe
          border
          style="width: 100%">
        <el-table-column
            prop="bills_id"
            label="账单ID">
        </el-table-column>
        <el-table-column
            prop="shipper"
            label="托运人">
        </el-table-column>
        <el-table-column
            prop="fee"
            label="费用">
        </el-table-column>
        <el-table-column
            prop="shipment_name"
            label="承运人">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "DemoIndex",
  data() {
    return {
      dialogCreateUserVisible: false,
      UserForm: {
        shipper: '',
        description: '',
        account_region: '',
        account_number: '',
        shipping_address: ''
      },
      Userrules: {
        shipper: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        description: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        account_region: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        account_number: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        shipping_address: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ]
      }
      ,
      formLabelWidth: '120px',

      dialogCreateOrderVisible: false,
      OrderForm: {
        order_status: '',
        shipping_address: '',
        delivery_address: '',
        shipper: '',
        receiver: ''
      },
      Orderrules: {
        order_status: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        shipping_address: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        delivery_address: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        shipper: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ],
        receiver: [
          { required:true,message: '请输入内容',trigger:'blur' }
        ]
      },

      SearchBillsForm: {
        name: ''
      },
      tableData: [],
      BillsForm: {
        bills_id: '',
        shipper: '',
        fee: '',
        shipment_name: ''
      }
    }
  },
  methods:{
    CreateUserSubmit(){
      const format = new FormData();
      format.append("shipper",this.UserForm.shipper);
      format.append("description",this.UserForm.description);
      format.append("account_region",this.UserForm.account_region);
      format.append("account_number",this.UserForm.account_number);
      format.append("shipping_address",this.UserForm.shipping_address);
      this.$refs.UserForm.validate((valid) => {
        if (valid) {
          axios({
            headers: {
              'Content-Type': 'application/json'
            },
            method: "post",
            data: format,
            url: this.$store.state.globalUrl + '/Create/CreateAccount'
          })
              .then(res => {
                console.log(res)
                this.$refs.UserForm.resetFields();
                this.dialogCreateUserVisible = false;
              }).catch(error => {
                console.log(error)
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      })
    },
    CreateOrderSubmit(){
      const format = new FormData();
      format.append("order_status",this.OrderForm.order_status);
      format.append("shipping_address",this.OrderForm.shipping_address);
      format.append("delivery_address",this.OrderForm.delivery_address);
      format.append("shipper",this.OrderForm.shipper);
      format.append("receiver",this.OrderForm.receiver);
      this.$refs.OrderForm.validate((valid) => {
        if (valid) {
          axios({
            headers: {
              'Content-Type': 'application/json'
            },
            method: "post",
            data: format,
            url: this.$store.state.globalUrl + '/Create/CreateOrder'
          })
              .then(res => {
                console.log(res)
                this.$refs.OrderForm.resetFields();
                this.dialogCreateOrderVisible = false;
              }).catch(error => {
            console.log(error)
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      })
    },
    SearchBillsSubmit(){
      axios({
        headers: {
          'Content-Type': 'application/json'
        },
        method:"get",
        url: this.$store.state.globalUrl + "/user/list_supplier?supplier_name="+this.SearchBillsForm.name
      })
          .then(res => {
            console.log(res.data)
            this.tableData = res.data;
            this.total = res.data.length;
          }).catch(error => {
        console.log(error);
      });
    },
    getList(){

    }
  }
}
</script>

<style scoped>

</style>