(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4396"],{"9gc0":function(e,t,a){"use strict";var l=a("mmX6");a.n(l).a},"9zZt":function(e,t,a){"use strict";a.r(t);var l=a("FyfS"),i=a.n(l),r=a("P2sY"),s=a.n(r),o=a("gDS+"),n=a.n(o),c=a("t3Un");a("Qyje");var p={name:"index",data:function(){return{inputSearch:void 0,selectSearch:void 0,listLoading:!0,tableData:[{id:"1",name:"王小虎",sex:0,age:28,employeeId:"员工号",telephone:"13185471256",companyId:"所属公司",inchargeLine:"所属路线",grade:"评级分数",complaintCount:"受到投诉次数",idcard:"131002199408204046",photoPath:"/static/imageDef.jpg",licensePath:"/static/imageDef.jpg",healthPath:"/static/imageDef.jpg",remark:"测试测试",address:"上海市普陀区金沙江路"}],multipleSelection:[],total:5,currentPage:void 0,pageSize:5,temp:{id:void 0,name:"",sex:0,age:20,employeeId:1e3,telephone:"",companyId:0,inchargeLine:1,grade:0,complaintCount:0,idcard:"",photoPath:"",licensePath:"",healthPath:"",remark:"",address:"廊坊市"},dialogStatus:"",dialogFormVisible:!1,dialogImgVisible:!1,textMap:{update:"Edit",create:"Create"},querykey:"employeeId",imageFaceUrl:"",imageCardUrl:"",imageMedicalUrl:"",imageDef:"/static/imageDef.jpg"}},created:function(){this.fetchData()},methods:{resetTemp:function(){this.temp={id:void 0,name:"",sex:1,age:20,employeeId:1e3,telephone:"",companyId:0,inchargeLine:1,grade:0,complaintCount:0,idcard:"",photoPath:"",remark:"",address:"廊坊市",healthPath:"",licensePath:""}},onSubmitAdd:function(){var e=this;this.resetTemp(),this.imageFaceUrl="",this.imageCardUrl="",this.imageMedicalUrl="",this.dialogStatus="create",this.dialogbutton="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.dataForm.clearValidate()})},dbClickRow:function(e){var t=this;""==e.licensePath||""==e.healthPath?this.$notify({title:"警告",message:"没有上传资料",type:"warning",duration:2e3}):(this.temp.licensePath=e.licensePath,this.temp.healthPath=e.healthPath,this.dialogImgVisible=!0,this.$nextTick(function(){t.$refs.imgForm.clearValidate()}))},handleSizeChange:function(e){this.pageSize=e,this.currentPage=1,this.fetchData()},handleCurrentChange:function(e){this.currentPage=e,this.fetchData()},handleSelectionChange:function(e){alert(123),this.fetchData()},callbackFunction:function(e){alert(e+"aaa")},onSubmitSearch:function(){void 0==this.selectSearch?this.$notify({title:"警告",message:"请选择查询条件",type:"warning",duration:2e3}):void 0==this.inputSearch?this.$notify({title:"警告",message:"请填写查询内容",type:"warning",duration:2e3}):this.fetchData()},onSubmitClear:function(){this.currentPage=void 0,this.selectSearch=void 0,this.inputSearch=void 0,this.imageFaceUrl="",this.imageCardUrl="",this.imageMedicalUrl="",this.fetchData()},fetchData:function(){var e=this;this.listLoading=!0,function(e,t,a,l){var i="";return i=0==a?{currentPage:e,pageSize:t,employeeId:l}:1==a?{currentPage:e,pageSize:t,idcard:l}:{currentPage:e,pageSize:t},Object(c.a)({url:"/drivermange/findDriverInfoByPage",method:"post",data:i})}(this.currentPage,this.pageSize,this.selectSearch,this.inputSearch).then(function(t){e.listLoading=!1,e.total=t.result.total,e.currentPage=t.result.current,e.tableData=t.result.records})},createData:function(){var e=this;console.log(this.temp),function(e){return Object(c.a)({url:"/drivermange/saveDriverInfo",method:"post",data:e})}(this.temp).then(function(t){console.log(t),"000"==t.code?(e.temp.id=t.result,e.tableData.unshift(e.temp),e.dialogFormVisible=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3})):e.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})})},handleUpdate:function(e){var t=this;alert(n()(e)),this.temp=s()({},e),this.imageFaceUrl=e.photoPath,this.imageCardUrl=e.licensePath,this.imageMedicalUrl=e.healthPath,this.dialogbutton="update",this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs.dataForm.clearValidate()})},updateData:function(){var e=this;console.log(),function(e){return Object(c.a)({url:"/drivermange/updateDriverInfo",method:"post",data:e})}(this.temp).then(function(t){if(console.log(t),"000"==t.code){var a=!0,l=!1,r=void 0;try{for(var s,o=i()(e.tableData);!(a=(s=o.next()).done);a=!0){var n=s.value;if(n.id===e.temp.id){var c=e.tableData.indexOf(n);e.tableData.splice(c,1,e.temp);break}}}catch(e){l=!0,r=e}finally{try{!a&&o.return&&o.return()}finally{if(l)throw r}}e.dialogFormVisible=!1,e.$notify({title:"成功",message:"编辑成功",type:"success",duration:2e3})}else e.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})})},handleDelete:function(e){var t=this;(function(e){return Object(c.a)({url:"/drivermange/forbideDriverInfos",method:"post",data:{id:e}})})(e.id).then(function(a){if(console.log(a),"000"==a.code){var l=t.tableData.indexOf(e);t.tableData.splice(l,1),t.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3})}else t.$notify({title:"失败",message:"创建失败",type:"error",duration:4e3})});var a=this.list.indexOf(e);this.list.splice(a,1)},handleAvatarSuccess:function(e,t){console.log(e),this.imageFaceUrl=e.result.url,this.temp.photoPath=e.result.url},handleAvatarSuccess1:function(e,t){console.log(e),this.imageCardUrl=e.result.url,this.temp.licensePath=e.result.url},handleAvatarSuccess2:function(e,t){console.log(e),this.imageMedicalUrl=e.result.url,this.temp.healthPath=e.result.url},beforeAvatarUpload:function(e){var t="image/jpeg"===e.type,a=e.size/1024/1024<2;return t||this.$message.error("上传头像图片只能是 JPG 格式!"),a||this.$message.error("上传头像图片大小不能超过 2MB!"),t&&a}}},d=(a("9gc0"),a("KHd+")),u=Object(d.a)(p,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-row",{staticClass:"el-row-left"},[a("el-col",{attrs:{span:6}},[a("el-input",{staticClass:"input-with-select",attrs:{placeholder:"请输入内容"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.onSubmitSearch(t):null}},model:{value:e.inputSearch,callback:function(t){e.inputSearch=t},expression:"inputSearch"}},[a("el-select",{staticStyle:{width:"100px"},attrs:{slot:"prepend",placeholder:"请选择"},slot:"prepend",model:{value:e.selectSearch,callback:function(t){e.selectSearch=t},expression:"selectSearch"}},[a("el-option",{attrs:{label:"工号",value:"0"}}),e._v(" "),a("el-option",{attrs:{label:"身份证",value:"1"}})],1)],1)],1),e._v(" "),a("el-col",{attrs:{span:1}},[a("el-button",{attrs:{type:"success",icon:"el-icon-search"},on:{click:e.onSubmitSearch}})],1),e._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary"},on:{click:e.onSubmitAdd}},[e._v("Add")])],1),e._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary"},on:{click:e.onSubmitClear}},[e._v("刷新")])],1)],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],ref:"multipleTable",staticStyle:{width:"98%",margin:"20px"},attrs:{"element-loading-text":"Loading",data:e.tableData,stripe:"",border:"","default-sort":{order:"descending"}},on:{"selection-change":e.handleSelectionChange,"row-dblclick":e.dbClickRow}},[a("el-table-column",{attrs:{prop:"id",label:"ID",sortable:"",width:"60"}}),e._v(" "),a("el-table-column",{attrs:{label:"个人信息",width:"180",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-popover",{attrs:{trigger:"hover",placement:"top"}},[a("p",[e._v("姓名: "+e._s(t.row.name))]),e._v(" "),a("p",[e._v("性别: "+e._s(0==t.row.sex?"男":"女"))]),e._v(" "),a("p",[e._v("身份证: "+e._s(t.row.idcard))]),e._v(" "),a("p",[e._v("住址: "+e._s(t.row.address))]),e._v(" "),a("p",[e._v("备注: "+e._s(t.row.remark))]),e._v(" "),a("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[t.row.photoPath?a("div",{staticClass:"avatartablerowfacediv"},[a("img",{attrs:{src:t.row.photoPath}})]):a("div",{staticClass:"avatartablerowfacediv"},[a("img",{attrs:{src:"/static/imageDef.jpg"}})]),e._v(" "),a("div",{staticClass:"avatartablerownamediv"},[a("el-tag",{attrs:{size:"medium"}},[e._v(e._s(t.row.name))])],1)])])]}}])}),e._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"age",label:"年龄",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"employeeId",label:"员工号",width:"90"}}),e._v(" "),a("el-table-column",{attrs:{prop:"telephone",label:"电话",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{label:"所属公司",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(0==t.row.companyId?"一公司":1==t.row.companyId?"二公司":2==t.row.companyId?"三公司":"四公司")+"\n      ")]}}])}),e._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"inchargeLine",label:"所属路线",width:"110"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"grade",label:"评级分数",width:"110"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"",prop:"complaintCount",label:"投诉次数",width:"110"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"驾照",width:"110"},scopedSlots:e._u([{key:"default",fn:function(e){return[e.row.licensePath?a("div",{staticClass:"avatartablerowcarddiv"},[a("img",{attrs:{src:e.row.licensePath}})]):a("div",{staticClass:"avatartablerowcarddiv"},[a("img",{attrs:{src:"/static/imageDef.jpg"}})])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"体检表",width:"110"},scopedSlots:e._u([{key:"default",fn:function(e){return[e.row.healthPath?a("div",{staticClass:"avatartablerowmedicadiv"},[a("img",{attrs:{src:e.row.healthPath}})]):a("div",{staticClass:"avatartablerowmedicadiv"},[a("img",{attrs:{src:"/static/imageDef.jpg"}})])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.handleUpdate(t.row)}}},[e._v("编辑\n        ")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.handleDelete(t.row)}}},[e._v("删除\n        ")])]}}])})],1),e._v(" "),a("el-pagination",{attrs:{background:"","current-page":e.currentPage,"page-size":e.pageSize,"page-sizes":[5,10,15,20],layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}}),e._v(" "),a("el-dialog",{attrs:{visible:e.dialogImgVisible},on:{"update:visible":function(t){e.dialogImgVisible=t}}},[a("el-form",{ref:"imgForm",staticStyle:{width:"700px",margin:"auto","text-align":"center"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"70px"}},[a("el-row",{staticClass:"dialogtempimgcard"},[a("img",{attrs:{src:e.temp.licensePath}})]),e._v(" "),a("el-row",{staticClass:"dialogtempimgmedica"},[a("img",{attrs:{src:e.temp.healthPath}})])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"dataForm",staticStyle:{width:"800px","margin-left":"50px"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"70px"}},[a("el-row",{staticClass:"form_data_label",attrs:{gutter:24}},[e._v("基本信息")]),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:2}},[e._v("姓名")]),e._v(" "),a("el-col",{attrs:{span:4}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("性别")]),e._v(" "),a("el-col",{attrs:{span:4}},[a("el-radio-group",{model:{value:e.temp.sex,callback:function(t){e.$set(e.temp,"sex",t)},expression:"temp.sex"}},[a("el-radio-button",{attrs:{label:"0"}},[e._v("男")]),e._v(" "),a("el-radio-button",{attrs:{label:"1"}},[e._v("女")])],1)],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("年龄")]),e._v(" "),a("el-col",{attrs:{span:3}},[a("el-input",{model:{value:e.temp.age,callback:function(t){e.$set(e.temp,"age",t)},expression:"temp.age"}})],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("电话")]),e._v(" "),a("el-col",{attrs:{span:5}},[a("el-input",{model:{value:e.temp.telephone,callback:function(t){e.$set(e.temp,"telephone",t)},expression:"temp.telephone"}})],1)],1),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:2}},[e._v("身份证")]),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-input",{model:{value:e.temp.idcard,callback:function(t){e.$set(e.temp,"idcard",t)},expression:"temp.idcard"}})],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("地址")]),e._v(" "),a("el-col",{attrs:{span:10}},[a("el-input",{model:{value:e.temp.address,callback:function(t){e.$set(e.temp,"address",t)},expression:"temp.address"}})],1)],1),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:2}},[e._v("头像")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{action:"http://localhost:8080/buscenter/uploaddriverimages/","show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.imageFaceUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageFaceUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("驾照")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{action:"http://localhost:8080/buscenter/uploaddriverimages/","show-file-list":!1,"on-success":e.handleAvatarSuccess1,"before-upload":e.beforeAvatarUpload}},[e.imageCardUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageCardUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),a("el-col",{attrs:{span:2}},[e._v("体检表")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{action:"http://localhost:8080/buscenter/uploaddriverimages/","show-file-list":!1,"on-success":e.handleAvatarSuccess2,"before-upload":e.beforeAvatarUpload}},[e.imageMedicalUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageMedicalUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)],1),e._v(" "),a("el-row",{staticClass:"form_data_label",attrs:{gutter:24}},[e._v("工作信息")]),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:2}},[e._v("员工号")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:e.temp.employeeId,callback:function(t){e.$set(e.temp,"employeeId",t)},expression:"temp.employeeId"}})],1),e._v(" "),a("el-col",{attrs:{span:3}},[e._v("所属公司")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-select",{attrs:{placeholder:"please select your zone"},model:{value:e.temp.companyId,callback:function(t){e.$set(e.temp,"companyId",t)},expression:"temp.companyId"}},[a("el-option",{attrs:{label:"Zone one",value:"0"}}),e._v(" "),a("el-option",{attrs:{label:"Zone two",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"Zone three",value:"2"}}),e._v(" "),a("el-option",{attrs:{label:"Zone fore",value:"3"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:3}},[e._v("所属路线")]),e._v(" "),a("el-col",{attrs:{span:4}},[a("el-select",{attrs:{placeholder:"please select your zone"},model:{value:e.temp.inchargeLine,callback:function(t){e.$set(e.temp,"inchargeLine",t)},expression:"temp.inchargeLine"}},[a("el-option",{attrs:{label:"Zone one",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"Zone two",value:"2"}})],1)],1)],1),e._v(" "),a("el-row",{staticClass:"form_data_label",attrs:{gutter:24}},[e._v("评价信息")]),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:3}},[e._v("评级分数")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:e.temp.grade,callback:function(t){e.$set(e.temp,"grade",t)},expression:"temp.grade"}})],1),e._v(" "),a("el-col",{attrs:{span:4}},[e._v("受到投诉次数")]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:e.temp.complaintCount,callback:function(t){e.$set(e.temp,"complaintCount",t)},expression:"temp.complaintCount"}})],1)],1),e._v(" "),a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:2}},[e._v("备注")]),e._v(" "),a("el-col",{attrs:{span:20}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("Clean")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){"create"===e.dialogStatus?e.createData():e.updateData()}}},[e._v(e._s(e.dialogbutton)+"\n      ")])],1)],1)],1)},[],!1,null,"769cd03f",null);u.options.__file="index.vue";t.default=u.exports},FyfS:function(e,t,a){e.exports={default:a("Rp86"),__esModule:!0}},Rp86:function(e,t,a){a("bBy9"),a("FlQf"),e.exports=a("fXsU")},fXsU:function(e,t,a){var l=a("5K7Z"),i=a("fNZA");e.exports=a("WEpk").getIterator=function(e){var t=i(e);if("function"!=typeof t)throw TypeError(e+" is not iterable!");return l(t.call(e))}},"gDS+":function(e,t,a){e.exports={default:a("oh+g"),__esModule:!0}},mmX6:function(e,t,a){},"oh+g":function(e,t,a){var l=a("WEpk"),i=l.JSON||(l.JSON={stringify:JSON.stringify});e.exports=function(e){return i.stringify.apply(i,arguments)}}}]);