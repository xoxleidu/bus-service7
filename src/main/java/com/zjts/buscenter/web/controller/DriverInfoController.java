package com.zjts.buscenter.web.controller;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.DriverInfoReq;
import com.zjts.buscenter.common.model.req.group.AddDriverBasic;
import com.zjts.buscenter.web.model.DriverInfo;
import com.zjts.buscenter.web.service.IDriverInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
