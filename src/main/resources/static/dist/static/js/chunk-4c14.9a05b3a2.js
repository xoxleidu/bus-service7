(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4c14"],{"5hJV":function(t,e,a){"use strict";var i=a("mg2w");a.n(i).a},FyfS:function(t,e,a){t.exports={default:a("Rp86"),__esModule:!0}},Goyz:function(t,e,a){"use strict";a.r(e);var i=a("FyfS"),l=a.n(i),n=a("P2sY"),o=a.n(n),s=a("t3Un");a("Qyje");var r={name:"index",data:function(){return{inputSearch:void 0,selectSearch:void 0,listLoading:!0,tableData:[{id:1,licenseNumber:"冀R88888",pathId:1,operationState:-1,affiliationCompany:"中交天枢",stationStatus:1,upDownStream:0,vehicleType:"城市公交",drivingKm:55555,faultid:1,maintenanceid:"已检验",manufactureDate:"2018-10-26",registrationNumber:22222,registrationDate:"2018-10-26",seating:40,fuelConsumption:"30L",identificationCode:"44444",engineNo:33333,factoryBrand:111111,busLength:11530.01,busWide:2500.01,busHigh:3040.01,airConditioned:0,busNote:"测试信息66666"}],multipleSelection:[],total:5,currentPage:void 0,pageSize:5,temp:{id:void 0,licenseNumber:"",pathId:void 0,operationState:-1,affiliationCompany:"",stationStatus:1,upDownStream:0,vehicleType:"",drivingKm:0,faultid:1,maintenanceid:"",manufactureDate:"",registrationNumber:void 0,registrationDate:"",seating:0,fuelConsumption:"",identificationCode:void 0,engineNo:void 0,factoryBrand:void 0,busLength:0,busWide:0,busHigh:0,airConditioned:0,busNote:""},dialogStatus:"",dialogFormVisible:!1,dialogImgVisible:!1,textMap:{update:"Edit",create:"Create"},querykey:"employeeId"}},created:function(){this.fetchData()},methods:{resetTemp:function(){this.temp={id:void 0,licenseNumber:"",pathId:void 0,operationState:-1,affiliationCompany:"",stationStatus:1,upDownStream:0,vehicleType:"",drivingKm:0,faultid:1,maintenanceid:"",manufactureDate:"",registrationNumber:void 0,registrationDate:"",seating:0,fuelConsumption:"",identificationCode:void 0,engineNo:void 0,factoryBrand:void 0,busLength:0,busWide:0,busHigh:0,airConditioned:0,busNote:""}},onSubmitAdd:function(){var t=this;this.resetTemp(),this.dialogStatus="create",this.dialogbutton="create",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs.dataForm.clearValidate()})},dbClickRow:function(t){var e=this;this.dialogImgVisible=!0,this.$nextTick(function(){e.$refs.imgForm.clearValidate()})},handleSizeChange:function(t){this.pageSize=t,this.currentPage=1,this.fetchData()},handleCurrentChange:function(t){this.currentPage=t,this.fetchData()},handleSelectionChange:function(t){this.fetchData()},callbackFunction:function(t){alert(t+"aaa")},onSubmitSearch:function(){void 0==this.selectSearch?this.$notify({title:"警告",message:"请选择查询条件",type:"warning",duration:2e3}):void 0==this.inputSearch?this.$notify({title:"警告",message:"请填写查询内容",type:"warning",duration:2e3}):this.fetchData()},onSubmitClear:function(){this.currentPage=void 0,this.selectSearch=void 0,this.inputSearch=void 0,this.fetchData()},fetchData:function(){var t=this;this.listLoading=!0,function(t,e,a,i){var l="";return l=0==a?{currentPage:t,pageSize:e,employeeId:i}:1==a?{currentPage:t,pageSize:e,idcard:i}:{currentPage:t,pageSize:e},Object(s.a)({url:"/buscontroller/findallbus",method:"post",data:l})}(this.currentPage,this.pageSize,this.selectSearch,this.inputSearch).then(function(e){t.listLoading=!1,t.total=e.result.total,t.currentPage=e.result.current,t.tableData=e.result.records})},createData:function(){var t=this;(function(t){return Object(s.a)({url:"/buscontroller/addbus",method:"post",data:t})})(this.temp).then(function(e){"000"==e.code?(t.temp.id=e.result,t.tableData.unshift(t.temp),t.dialogFormVisible=!1,t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3})):t.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})})},handleUpdate:function(t){var e=this;this.temp=o()({},t),this.dialogbutton="update",this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.dataForm.clearValidate()})},updateData:function(){var t=this;(function(t){return Object(s.a)({url:"/buscontroller/updatebus",method:"post",data:t})})(this.temp).then(function(e){if("000"==e.code){var a=!0,i=!1,n=void 0;try{for(var o,s=l()(t.tableData);!(a=(o=s.next()).done);a=!0){var r=o.value;if(r.id===t.temp.id){var u=t.tableData.indexOf(r);t.tableData.splice(u,1,t.temp);break}}}catch(t){i=!0,n=t}finally{try{!a&&s.return&&s.return()}finally{if(i)throw n}}t.dialogFormVisible=!1,t.$notify({title:"成功",message:"编辑成功",type:"success",duration:2e3})}else t.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})})},handleDelete:function(t){var e=this;(function(t){return Object(s.a)({url:"/buscontroller/deletebuslist",method:"post",data:{id:t}})})(t.id).then(function(a){if("000"==a.code){var i=e.tableData.indexOf(t);e.tableData.splice(i,1),e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3})}else e.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})});var a=this.list.indexOf(t);this.list.splice(a,1)}}},u=(a("5hJV"),a("KHd+")),c=Object(u.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-row",{staticClass:"el-row-left"},[a("el-col",{attrs:{span:6}},[a("el-input",{staticClass:"input-with-select",attrs:{placeholder:"请输入内容"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.onSubmitSearch(e):null}},model:{value:t.inputSearch,callback:function(e){t.inputSearch=e},expression:"inputSearch"}},[a("el-select",{staticStyle:{width:"100px"},attrs:{slot:"prepend",placeholder:"请选择"},slot:"prepend",model:{value:t.selectSearch,callback:function(e){t.selectSearch=e},expression:"selectSearch"}},[a("el-option",{attrs:{label:"线路",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"车牌号",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:1}},[a("el-button",{attrs:{type:"success",icon:"el-icon-search"},on:{click:t.onSubmitSearch}})],1),t._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary"},on:{click:t.onSubmitAdd}},[t._v("Add")])],1),t._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary"},on:{click:t.onSubmitClear}},[t._v("刷新")])],1)],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"multipleTable",staticStyle:{width:"98%",margin:"20px"},attrs:{"element-loading-text":"Loading",data:t.tableData,stripe:"",border:"","default-sort":{order:"descending"}},on:{"selection-change":t.handleSelectionChange,"row-dblclick":t.dbClickRow}},[a("el-table-column",{attrs:{prop:"id",label:"ID",sortable:"",width:"60"}}),t._v(" "),a("el-table-column",{attrs:{label:"个人信息",width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-popover",{attrs:{trigger:"hover",placement:"top"}},[a("p",[t._v("车辆登记编号: "+t._s(e.row.registrationNumber))]),t._v(" "),a("p",[t._v("登记日期: "+t._s(e.row.registrationDate)+" | 座位数: "+t._s(e.row.seating)+" | 油耗: "+t._s(e.row.fuelConsumption))]),t._v(" "),a("p",[t._v("车辆识别码: "+t._s(e.row.identificationCode)+" | 发动机号: "+t._s(e.row.engineNo))]),t._v(" "),a("p",[t._v("厂牌号: "+t._s(e.row.factoryBrand))]),t._v(" "),a("p",[t._v("车身长: "+t._s(e.row.busLength)+" | 车身宽: "+t._s(e.row.busWide)+" | 车身高: "+t._s(e.row.busHigh))]),t._v(" "),a("p",[t._v("车标记: "+t._s(1==e.row.airConditioned?"空调车":"非空调车"))]),t._v(" "),a("p",[t._v("备注: "+t._s(e.row.busNote))]),t._v(" "),a("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[0==e.row.operationState?a("div",{staticClass:"avatartablerowfacediv"},[a("el-tag",{attrs:{type:"danger"}},[t._v("运营中")])],1):a("div",{staticClass:"avatartablerowfacediv"},[a("el-tag",{attrs:{type:"success"}},[t._v("非运营")])],1),t._v(" "),a("div",{staticClass:"avatartablerownamediv"},[a("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.licenseNumber))])],1)])])]}}])}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"pathId",label:"路线",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"affiliationCompany",label:"所属公司",width:"90"}}),t._v(" "),a("el-table-column",{attrs:{label:"进出站状态",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(0==e.row.stationStatus?"站外":"站内")+"\n      ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"上下行状态",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(0==e.row.upDownStream?"上行":"下行")+"\n      ")]}}])}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"vehicleType",label:"车辆类型",width:"110"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"drivingKm",label:"行驶公里",width:"110"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"faultid",label:"事故信息",width:"110"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"maintenanceid",label:"验车信息",width:"110"}}),t._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"manufactureDate",label:"出厂日期",width:"110"}}),t._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.handleUpdate(e.row)}}},[t._v("编辑\n        ")]),t._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){t.handleDelete(e.row)}}},[t._v("删除\n        ")])]}}])})],1),t._v(" "),a("el-pagination",{attrs:{background:"","current-page":t.currentPage,"page-size":t.pageSize,"page-sizes":[5,10,15,20],layout:"total, sizes, prev, pager, next, jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}}),t._v(" "),a("el-dialog",{attrs:{visible:t.dialogImgVisible},on:{"update:visible":function(e){t.dialogImgVisible=e}}},[a("el-form",{ref:"imgForm",staticStyle:{width:"700px",margin:"auto","text-align":"center"},attrs:{rules:t.rules,model:t.temp,"label-position":"left","label-width":"70px"}},[a("el-row",{staticClass:"dialogtempimgcard"},[a("p",[t._v("车辆登记编号: "+t._s(t.temp.registrationNumber))]),t._v(" "),a("p",[t._v("登记日期: "+t._s(t.temp.registrationDate)+" | 座位数: "+t._s(t.temp.seating)+" | 油耗: "+t._s(t.temp.fuelConsumption))]),t._v(" "),a("p",[t._v("车辆识别码: "+t._s(t.temp.identificationCode)+" | 发动机号: "+t._s(t.temp.engineNo))]),t._v(" "),a("p",[t._v("厂牌号: "+t._s(t.temp.factoryBrand))]),t._v(" "),a("p",[t._v("车身长: "+t._s(t.temp.busLength)+" | 车身宽: "+t._s(t.temp.busWide)+" | 车身高: "+t._s(t.temp.busHigh))]),t._v(" "),a("p",[t._v("车标记: "+t._s(1==t.temp.airConditioned?"空调车":"非空调车"))]),t._v(" "),a("p",[t._v("备注: "+t._s(t.temp.busNote))])])],1)],1),t._v(" "),a("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{ref:"dataForm",staticStyle:{width:"800px","margin-left":"20px"},attrs:{rules:t.rules,model:t.temp,"label-position":"left","label-width":"70px"}},[a("el-row",{staticClass:"form_data_label",attrs:{gutter:16}},[t._v("基本信息")]),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:2}},[t._v("车牌号")]),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-input",{model:{value:t.temp.licenseNumber,callback:function(e){t.$set(t.temp,"licenseNumber",e)},expression:"temp.licenseNumber"}})],1),t._v(" "),a("el-col",{attrs:{span:2}},[t._v("座位")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-input",{model:{value:t.temp.seating,callback:function(e){t.$set(t.temp,"seating",e)},expression:"temp.seating"}})],1),t._v(" "),a("el-col",{attrs:{span:2}},[t._v("油耗")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-input",{model:{value:t.temp.fuelConsumption,callback:function(e){t.$set(t.temp,"fuelConsumption",e)},expression:"temp.fuelConsumption"}})],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:3}},[t._v("车辆识别码")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{model:{value:t.temp.identificationCode,callback:function(e){t.$set(t.temp,"identificationCode",e)},expression:"temp.identificationCode"}})],1),t._v(" "),a("el-col",{attrs:{span:3}},[t._v("发动机号")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{model:{value:t.temp.engineNo,callback:function(e){t.$set(t.temp,"engineNo",e)},expression:"temp.engineNo"}})],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:2}},[t._v("厂牌号")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{model:{value:t.temp.factoryBrand,callback:function(e){t.$set(t.temp,"factoryBrand",e)},expression:"temp.factoryBrand"}})],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-radio-group",{model:{value:t.temp.airConditioned,callback:function(e){t.$set(t.temp,"airConditioned",e)},expression:"temp.airConditioned"}},[a("el-radio-button",{attrs:{label:"1"}},[t._v("空调车")]),t._v(" "),a("el-radio-button",{attrs:{label:"2"}},[t._v("非空调车")])],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:2}},[t._v("车身长")]),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-input",{model:{value:t.temp.busLength,callback:function(e){t.$set(t.temp,"busLength",e)},expression:"temp.busLength"}})],1),t._v(" "),a("el-col",{attrs:{span:2}},[t._v("车身宽")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-input",{model:{value:t.temp.busWide,callback:function(e){t.$set(t.temp,"busWide",e)},expression:"temp.busWide"}})],1),t._v(" "),a("el-col",{attrs:{span:2}},[t._v("车身高")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-input",{model:{value:t.temp.busHigh,callback:function(e){t.$set(t.temp,"busHigh",e)},expression:"temp.busHigh"}})],1)],1),t._v(" "),a("el-row",{staticClass:"form_data_label",attrs:{gutter:16}},[t._v("工作信息")]),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:6}},[a("el-radio-group",{model:{value:t.temp.operationState,callback:function(e){t.$set(t.temp,"operationState",e)},expression:"temp.operationState"}},[a("el-radio-button",{attrs:{label:"0"}},[t._v("运营中")]),t._v(" "),a("el-radio-button",{attrs:{label:"1"}},[t._v("非运营")])],1)],1),t._v(" "),a("el-col",{attrs:{span:3}},[t._v("所属公司")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-select",{attrs:{placeholder:"please select your zone"},model:{value:t.temp.affiliationCompany,callback:function(e){t.$set(t.temp,"affiliationCompany",e)},expression:"temp.affiliationCompany"}},[a("el-option",{attrs:{label:"Zone one",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"Zone two",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"Zone three",value:"2"}}),t._v(" "),a("el-option",{attrs:{label:"Zone fore",value:"3"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:3}},[t._v("所属路线")]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-select",{attrs:{placeholder:"please select your zone"},model:{value:t.temp.pathId,callback:function(e){t.$set(t.temp,"pathId",e)},expression:"temp.pathId"}},[a("el-option",{attrs:{label:"Zone one",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"Zone two",value:"2"}})],1)],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:3}},[t._v("车辆类型")]),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-select",{attrs:{placeholder:"please select your zone"},model:{value:t.temp.vehicleType,callback:function(e){t.$set(t.temp,"vehicleType",e)},expression:"temp.vehicleType"}},[a("el-option",{attrs:{label:"Zone one",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"Zone two",value:"2"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-radio-group",{model:{value:t.temp.stationStatus,callback:function(e){t.$set(t.temp,"stationStatus",e)},expression:"temp.stationStatus"}},[a("el-radio-button",{attrs:{label:"1"}},[t._v("站外")]),t._v(" "),a("el-radio-button",{attrs:{label:"2"}},[t._v("站内")])],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-radio-group",{model:{value:t.temp.upDownStream,callback:function(e){t.$set(t.temp,"upDownStream",e)},expression:"temp.upDownStream"}},[a("el-radio-button",{attrs:{label:"1"}},[t._v("上行")]),t._v(" "),a("el-radio-button",{attrs:{label:"2"}},[t._v("下行")])],1)],1)],1),t._v(" "),a("el-row",{staticClass:"form_data_label",attrs:{gutter:16}},[t._v("健康信息")]),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:6}},[a("el-radio-group",{model:{value:t.temp.maintenanceid,callback:function(e){t.$set(t.temp,"maintenanceid",e)},expression:"temp.maintenanceid"}},[a("el-radio-button",{attrs:{label:"0"}},[t._v("已检验")]),t._v(" "),a("el-radio-button",{attrs:{label:"1"}},[t._v("未检验")])],1)],1),t._v(" "),a("el-col",{attrs:{span:3}},[t._v("事故信息")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:t.temp.faultid,callback:function(e){t.$set(t.temp,"faultid",e)},expression:"temp.faultid"}})],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:3}},[t._v("出厂日期")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:t.temp.manufactureDate,callback:function(e){t.$set(t.temp,"manufactureDate",e)},expression:"temp.manufactureDate"}})],1),t._v(" "),a("el-col",{attrs:{span:3}},[t._v("行驶公里")]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:t.temp.drivingKm,callback:function(e){t.$set(t.temp,"drivingKm",e)},expression:"temp.drivingKm"}})],1)],1),t._v(" "),a("el-row",{attrs:{gutter:16}},[a("el-col",{attrs:{span:2}},[t._v("备注")]),t._v(" "),a("el-col",{attrs:{span:16}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.temp.busNote,callback:function(e){t.$set(t.temp,"busNote",e)},expression:"temp.busNote"}})],1)],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("Clean")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){"create"===t.dialogStatus?t.createData():t.updateData()}}},[t._v(t._s(t.dialogbutton)+"\n      ")])],1)],1)],1)},[],!1,null,"f0c92426",null);c.options.__file="index.vue";e.default=c.exports},Rp86:function(t,e,a){a("bBy9"),a("FlQf"),t.exports=a("fXsU")},fXsU:function(t,e,a){var i=a("5K7Z"),l=a("fNZA");t.exports=a("WEpk").getIterator=function(t){var e=l(t);if("function"!=typeof e)throw TypeError(t+" is not iterable!");return i(e.call(t))}},mg2w:function(t,e,a){}}]);