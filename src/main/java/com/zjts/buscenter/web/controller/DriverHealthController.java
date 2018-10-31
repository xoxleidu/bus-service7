package com.zjts.buscenter.web.controller;//package com.zjts.buscenter.web.controller;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.zjts.buscenter.common.constant.CodeEnum;
//import com.zjts.buscenter.common.model.APIResponse;
//import com.zjts.buscenter.common.model.req.DriverHealthReq;
//import com.zjts.buscenter.common.model.req.DriverInfoReq;
//import com.zjts.buscenter.common.model.req.DriverLicenseReq;
//import com.zjts.buscenter.common.model.req.group.DeleteDriverInfo;
//import com.zjts.buscenter.web.model.DriverHealth;
//import com.zjts.buscenter.web.model.DriverInfo;
//import com.zjts.buscenter.web.model.DriverLicense;
//import com.zjts.buscenter.web.service.IDriverHealthService;
//import com.zjts.buscenter.web.service.IDriverInfoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
///**
// * <p>
// * 驾驶员体检信息表 前端控制器
// * </p>
// *
// * @author han zq
// * @since 2018-10-29
// */
//@Api(tags = "驾驶员接口",description = "驾驶员体检信息管理接口")
//@RestController
//@RequestMapping("/drivermange")
//public class DriverHealthController extends BaseController {
//
//    private templates final Logger logger = LoggerFactory.getLogger(DriverInfoController.class);
//
//    @Autowired
//    private IDriverHealthService driverHealthService;
//
//    @ApiOperation("新增驾驶员体检信息")
//    @PostMapping("/saveDriverHealthInfo")
//    public APIResponse saveDriverHealthInfo(
//            @RequestBody @Validated() DriverHealthReq driverHealthReq, BindingResult result){
//        if(result.hasErrors())
//            parameterVerification(result);
//        try {
//            DriverHealth driverHealth = new DriverHealth();
//            driverHealth.setModifiedTime(new Date());
//            BeanUtils.copyProperties(driverHealthReq,driverHealth);
//
//            boolean a = driverHealthService.insert(driverHealth);
//            if(a)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.SAVE_ERROR);
//        }
//        return APIResponse.error(CodeEnum.SAVE_ERROR);
//    }
//    @ApiOperation("修改驾驶员体检信息")
//    @PostMapping("/updateDriverHealthInfo")
//    public APIResponse updateDriverHealthInfo(
//            @RequestBody @Validated DriverHealthReq driverHealthReq, BindingResult result
//    ){
//        if(result.hasErrors())
//            parameterVerification(result);
//        try{
//            DriverHealth driverHealth = new DriverHealth();
//            BeanUtils.copyProperties(driverHealthReq,driverHealth);
//            boolean flag = driverHealthService
//                    .update(driverHealth,new EntityWrapper<DriverHealth>()
//                            .eq("employee_id",driverHealth.getEmployeeId()));
//            if(flag)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
//        }
//        return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
//    }
//
//}
