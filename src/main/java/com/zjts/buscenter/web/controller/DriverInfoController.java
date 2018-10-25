package com.zjts.buscenter.web.controller;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.DriverInfoReq;
import com.zjts.buscenter.common.model.req.group.AddDriverBasic;
import com.zjts.buscenter.util.BeanUtil;
import com.zjts.buscenter.web.model.DriverInfo;
import com.zjts.buscenter.web.model.PageHelper;
import com.zjts.buscenter.web.service.IDriverInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @ApiOperation("新增驾驶员信息")
    @PostMapping("/saveDriverInfo")
    public APIResponse saveDriverInfo(
            @RequestBody @Validated(AddDriverBasic.class)DriverInfoReq driverInfoReq, BindingResult result){
            if(result.hasErrors())
                parameterVerification(result);
        try {
            DriverInfo driverInfo = new DriverInfo();
            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            driverInfo.setCreatedTime(new Date());
            driverInfo.setModifiedTime(new Date());
            BeanUtils.copyProperties(driverInfoReq,driverInfo);
            System.out.println(driverInfo.toString());
            System.out.flush();
            boolean a = driverInfoService.insert(driverInfo);
            if(a)
                return APIResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }

        return APIResponse.error(CodeEnum.SAVE_ERROR);
    }


    @ApiOperation("禁用驾驶员信息")
    @PostMapping("/forbideDriverInfo")
    public APIResponse forbideDriverInfo(
            @RequestBody @ApiParam(name = "employeeId",value = "员工号") Integer employeeId){
        try {
            DriverInfo driver = new DriverInfo();
            driver.setEmployeeId(employeeId);
            driver.setStatus(1);
            boolean flag =    driverInfoService
                 .update(driver, new EntityWrapper<DriverInfo>().eq("employee_id", employeeId));
            if(flag)
                return APIResponse.success();

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,e.getMessage());
        }
        return APIResponse.error(CodeEnum.ERROR,"禁用失败,请稍后重试!");
    }


    @ApiOperation("删除驾驶员信息")
    @PostMapping("/deleteDriverInfo")
    public APIResponse deleteDriverInfo(
            @RequestBody @ApiParam(name = "employeeId",value = "员工号") Integer employeeId){
        try{
            boolean flag = driverInfoService
                    .delete(new EntityWrapper<DriverInfo>().eq("employee_id",employeeId));
            if(flag)
                return APIResponse.success();
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
        }
        return APIResponse.error(CodeEnum.ERROR,"删除失败,请稍后再试!");
    }

    @ApiOperation("修改驾驶员信息")
    @PostMapping("/updateDriverInfo")
    public APIResponse updateDriverInfo(
            @RequestBody @Validated()DriverInfoReq driverInfoReq, BindingResult result
    ){
        if(result.hasErrors())
            parameterVerification(result);
        try{
            DriverInfo driver = new DriverInfo();
            BeanUtils.copyProperties(driverInfoReq,driver);
            boolean flag = driverInfoService
                    .update(driver,new EntityWrapper<DriverInfo>().eq("employee_id",driver.getEmployeeId()));
            if(flag)
                return APIResponse.success();
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
        }
        return APIResponse.error(CodeEnum.ERROR,"修改失败,请稍后再试!");
    }

    @ApiOperation("查询单条驾驶员信息")
    @PostMapping("/findOneDriverInfo")
    public APIResponse findOneDriverInfo(
            @RequestBody DriverInfoReq driverInfoReq){
        try {
            DriverInfo driverInfo = new DriverInfo();
            BeanUtils.copyProperties(driverInfoReq,driverInfo);
            Wrapper wrapper = new EntityWrapper<DriverInfo>(driverInfo);
            DriverInfo driverInfo1 =  driverInfoService.selectOne(wrapper);
            if(driverInfo1 !=null )
                return APIResponse.success(driverInfo1);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
        }

        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
    }

    @ApiOperation(value = "分页显示全部驾驶员信息",notes = "curretn为当前页,size为")
    @PostMapping("/findDriverInfoByPage")
    public APIResponse findDriverInfoByPage(
            @RequestBody PageHelper pageHelper){
        try{
          Page  page1 =  driverInfoService.selectPage(new Page<DriverInfo>(pageHelper.getCurrentPage(),pageHelper.getPageSize()),new EntityWrapper<DriverInfo>());
          List list =page1.getRecords();
          if(list.size()>0)
          return APIResponse.success(list);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"查询失败,请稍后再试!");
        }
        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
    }

}