//package com.zjts.buscenter.web.controller;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.zjts.buscenter.common.constant.CodeEnum;
//import com.zjts.buscenter.common.model.APIResponse;
//import com.zjts.buscenter.common.model.req.DriverInfoReq;
//import com.zjts.buscenter.common.model.req.DriverLicenseReq;
//import com.zjts.buscenter.web.model.DriverInfo;
//import com.zjts.buscenter.web.model.DriverLicense;
//import com.zjts.buscenter.web.service.IDriverLicenseService;
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
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * <p>
// * 司机驾驶证, 前端控制器
// * </p>
// *
// * @author han zq
// * @since 2018-10-24
// */
//@Api(tags = "驾驶证接口",description="驾驶证信息管理")
//@RestController
//@RequestMapping("/licenseManage")
//public class DriverLicenseController extends BaseController {
//    private static final Logger logger = LoggerFactory.getLogger(DriverLicenseController.class);
//
//    @Autowired
//    private IDriverLicenseService driverLicenseService;
//
//    @ApiOperation("新增驾驶证信息")
//    @PostMapping("/saveDriverLicense")
//    public APIResponse saveDriverLicense(
//            @RequestBody @Validated DriverLicenseReq driverLicenseReq, BindingResult result
//            ){
//
//        if(result.hasErrors())
//            parameterVerification(result);
//        try {
//            DriverLicense driverLicense = new DriverLicense();
//            BeanUtils.copyProperties(driverLicenseReq,driverLicense);
//            driverLicense.setModifiedTime(new Date());
//            boolean a = driverLicenseService.insert(driverLicense);
//            if(a)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.SAVE_ERROR);
//        }
//        return APIResponse.error(CodeEnum.SAVE_ERROR);
//    }
//
//    @ApiOperation("修改驾驶证信息")
//    @PostMapping("/updateDriverLicense")
//    public APIResponse updateDriverLicense(
//            @RequestBody @Validated DriverLicenseReq driverLicenseReq, BindingResult result
//    ){
//        if(result.hasErrors())
//            parameterVerification(result);
//        try{
//            DriverLicense driverLicense = new DriverLicense();
//            BeanUtils.copyProperties(driverLicenseReq,driverLicense);
//            boolean flag = driverLicenseService
//                    .update(driverLicense,new EntityWrapper<DriverLicense>()
//                            .eq("employee_id",driverLicense.getEmployeeId()));
//            if(flag)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
//        }
//        return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
//    }
//    @ApiOperation("查询驾驶证信息")
//    @PostMapping("/findDriverLicense")
//    public APIResponse findDriverLicense(
//            @RequestBody DriverLicenseReq driverLicenseReq){
//        try {
//            DriverLicense driverLicense = new DriverLicense();
//            BeanUtils.copyProperties(driverLicenseReq,driverLicense);
//            Wrapper wrapper = new EntityWrapper<DriverLicense>(driverLicense);
//            DriverLicense driverLicense1 =  driverLicenseService.selectOne(wrapper);
//            if(driverLicense1 !=null )
//                return APIResponse.success(driverLicense1);
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
//        }
//
//        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
//    }
//
//
//}
