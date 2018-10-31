package com.zjts.buscenter.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.DriverInfoReq;
import com.zjts.buscenter.common.model.req.group.DeleteDriverInfo;
import com.zjts.buscenter.common.model.req.group.UpdateDriverInfo;
import com.zjts.buscenter.web.model.DriverInfo;
import com.zjts.buscenter.web.service.IDriverInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 驾驶员的基本信息表 前端控制器
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */
@Api(tags = "驾驶员接口",description = "驾驶员信息管理")
@RestController
@RequestMapping("/drivermange")
public class DriverInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DriverInfoController.class);

    @Autowired
    private IDriverInfoService driverInfoService;
//    @Autowired
//    private IDriverLicenseService driverLicenseService;

    @ApiOperation("新增驾驶员信息")
    @PostMapping("/saveDriverInfo")
    public APIResponse saveDriverInfo(
            @RequestBody @Validated() DriverInfoReq driverInfoReq, BindingResult result){
        if(result.hasErrors())
                parameterVerification(result);
        try {
            DriverInfo driverInfo = new DriverInfo();
            driverInfo.setCreatedTime(new Date());
            driverInfo.setModifiedTime(new Date());
            BeanUtils.copyProperties(driverInfoReq,driverInfo);
            boolean a = driverInfoService.insert(driverInfo);
            DriverInfo driver = driverInfoService.selectOne(new EntityWrapper<DriverInfo>(driverInfo));
            if(a)
                return APIResponse.success(driver.getId());
        }catch (Exception e){
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }

        return APIResponse.error(CodeEnum.SAVE_ERROR);
    }


//    @ApiOperation("禁用驾驶员信息")
//    @PostMapping("/forbideDriverInfo")
//    public APIResponse forbideDriverInfo(
//            @RequestBody @ApiParam(name = "Id",value = "员工序号") Integer id){
//        try {
//            DriverInfo driver = new DriverInfo();
//            driver.setEmployeeId(id);
//            driver.setStatus(1);
//            boolean flag = driverInfoService
//                    .updateAllColumnById(driver);
//
//            if(flag)
//                return APIResponse.success();
//
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,e.getMessage());
//        }
//        return APIResponse.error(CodeEnum.ERROR,"禁用失败,请稍后重试!");
//    }


//    @ApiOperation("删除驾驶员信息")
//    @PostMapping("/deleteDriverInfo")
//    public APIResponse deleteDriverInfo(
//            @RequestBody @ApiParam(name = "Id",value = "员工序号") Integer Id){
//        try{
////            boolean flag1 = driverLicenseService
////                    .delete(new EntityWrapper<DriverLicense>().eq("employee_id",employeeId));
//            boolean flag = driverInfoService
//                    .delete(new EntityWrapper<DriverInfo>().eq("employee_id",employeeId));
//            System.out.println("缺少照片的删除功能");
//            System.out.println("缺少体检信息的删除功能");
//            System.out.flush();
//            if(flag)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
//        }
//        return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
//    }

    @ApiOperation("修改驾驶员信息")
    @PostMapping("/updateDriverInfo")
    public APIResponse updateDriverInfo(
            @RequestBody @Validated()DriverInfoReq driverInfoReq,BindingResult result){
        if(result.hasErrors())
            parameterVerification(result);
        try{
            if(driverInfoReq.getId() ==null)
                return APIResponse.error(CodeEnum.ERROR,"id不能为空");
            DriverInfo driver = new DriverInfo();
            BeanUtils.copyProperties(driverInfoReq,driver);
            boolean flag = driverInfoService
                    .update(driver,new EntityWrapper<DriverInfo>()
                            .eq("id",driver.getId()));
            if(flag)
                return APIResponse.success(driver.getId());
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
        return APIResponse.error(CodeEnum.UPDATE_ERROR);
    }

//    @ApiOperation("通过手机号查询单条驾驶员信息")
//    @PostMapping("/findDriverInfoByPhone")
//    public APIResponse findDriverInfoByPhone(
//            @RequestBody String telephone,
//            PageHelper pageHelper){
//        try {
//
//            DriverInfo driverInfo = driverInfoService.
//                    selectOne(new EntityWrapper<DriverInfo>().eq("telephone",telephone));
//            if(driverInfo !=null)
//                return APIResponse.success(driverInfo);
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
//        }
//        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
//    }

    @ApiOperation("查询员工号是否存在")
    @PostMapping("/findDriverByEmployeeId")
    public APIResponse findDriverByEmployeeId(
            @RequestBody DriverInfoReq driverInfoReq){
        try {
            DriverInfo driverInfo = driverInfoService.
                    selectOne(new EntityWrapper<DriverInfo>()
                            .eq("employee_id",driverInfoReq.getEmployeeId()).eq("status",0));
            if(driverInfo == null)
                return APIResponse.success("该员工号可以使用");
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
        }

        return APIResponse.error(CodeEnum.EXIT_ERROR);
    }

//    @ApiOperation("通过员工号查询单条驾驶员信息")
//    @PostMapping("/findDriverInfoByEmployeeId")
//    public APIResponse findDriverInfoByEmployeeId(
//            @RequestBody String employeeId,
//            PageHelper pageHelper){
//        try {
//
//            DriverInfo driverInfo =
//                    driverInfoService.selectOne(new EntityWrapper<DriverInfo>().eq("employee_id",employeeId));
//            if(driverInfo !=null)
//                return APIResponse.success(driverInfo);
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
//        }
//
//        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
//    }

//    @ApiOperation("通过人名模糊查询驾驶员信息")
//    @PostMapping("/findDriverInfoByName")
//    public APIResponse findOneDriverInfoByName(
//            @RequestBody String name,
//            PageHelper pageHelper){
//        try {
//            DriverInfo driverInfo = new DriverInfo();
//            driverInfo.setName(name);
//            Wrapper wrapper = new EntityWrapper<DriverInfo>();
//            Page page1 = driverInfoService.selectPage(
//                    new Page<DriverInfo>(pageHelper.getCurrentPage(),pageHelper.getPageSize()),
//                    new EntityWrapper<DriverInfo>().like("name",driverInfo.getName())
//            );
//
//            List list =page1.getRecords();
//            if(list.size()>0)
//                return APIResponse.success(page1);
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
//        }
//
//        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
//    }

    @ApiOperation(value = "分页显示全部驾驶员信息,姓名模糊查询,员工号单条信息,手机号,身份证号")
    @PostMapping("/findDriverInfoByPage")
    public APIResponse findDriverInfoByPage(@RequestBody DriverInfoReq driverInfoReq){
        try{

            Page<DriverInfo> page = new Page<DriverInfo>(driverInfoReq.getCurrentPage(),driverInfoReq.getPageSize());
            DriverInfo driverInfo = new DriverInfo();
            BeanUtils.copyProperties(driverInfoReq,driverInfo);

            if(StringUtils.isEmpty(driverInfo.getName())) {
                Page page1 =driverInfoService.selectPage(page,new EntityWrapper<DriverInfo>(driverInfo).eq("status",0));
                if(page1.getRecords().size() > 0)
                    return APIResponse.success(page1);
            }
            Page page2 = driverInfoService
                    .selectPage(page, new EntityWrapper<DriverInfo>().eq("status",0)
                            .like("name",driverInfo.getName()));
            if(page2.getRecords().size() > 0)
                return APIResponse.success(page2);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
        }
        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
    }


//    @ApiOperation(value = "删除驾驶员信息")
//    @PostMapping("/deleteDriverInfos")
//    public APIResponse deleteDriverInfos(
//            @RequestBody @Validated({DeleteDriverInfo.class}) DriverInfoReq driverInfoReq){
//        try{
//
//            boolean flag  = driverInfoService.delete(new EntityWrapper<DriverInfo>().eq("id",driverInfoReq.getId()));
//            if(flag)
//                return APIResponse.success();
//        }catch (Exception e){
//            logger.error("出现异常 : "+e.getMessage());
//            e.printStackTrace();
//            return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
//        }
//        return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
//    }

    @ApiOperation(value = "禁用驾驶员")
    @PostMapping("/forbideDriverInfos")
    public APIResponse forbideDriverInfos(
            @RequestBody @Validated({UpdateDriverInfo.class}) DriverInfoReq driverInfoReq,BindingResult result){
        if(result.hasErrors())
            parameterVerification(result);
        try{
            DriverInfo driver = new DriverInfo();
            driver.setStatus(1);
            boolean flag  = driverInfoService.update(driver,new EntityWrapper<DriverInfo>().eq("id",driverInfoReq.getId()));
            if(flag)
                return APIResponse.success();
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"禁用失败,请稍后再试!");
        }
        return APIResponse.error(CodeEnum.SAVE_ERROR,"禁用失败,请稍后再试!");
    }
}
