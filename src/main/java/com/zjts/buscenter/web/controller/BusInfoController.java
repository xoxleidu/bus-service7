/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-24
 * Time: 13:37
 */
package com.zjts.buscenter.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.BusInfoReq;
import com.zjts.buscenter.web.model.BusInfo;

import com.zjts.buscenter.web.model.PageHelper;
import com.zjts.buscenter.web.service.IBusInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Api(tags = "公交管理接口",description = "公交管理信息管理")
@RestController
@RequestMapping(value = "/buscontroller",produces = "application/json")
public class BusInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BusInfoController.class);

    @Autowired
    private IBusInfoService busInfoService;

    @ApiOperation(value = "新增公交车")
    @PostMapping(value = "/addbus")
    public APIResponse addBus(@RequestBody @Validated BusInfoReq busReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo bus = new BusInfo();
            BeanUtils.copyProperties(busReq,bus);
            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            bus.setRegistrationDate(new Date());
            System.out.println(bus.getRegistrationDate());
            boolean b = busInfoService.insert(bus);
            if (b){
                return APIResponse.success();
            }
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }

    @ApiOperation(value = "通过车牌号查找单一Bus")
    @GetMapping(value = "/findbusbyid")
    public APIResponse findBusByid(@RequestBody @ApiParam(name = "licenseNumber",value = "车牌号") String licenseNumber, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo busInfo = busInfoService.selectOne(new EntityWrapper<BusInfo>().eq("license_number",licenseNumber));

            if(busInfo.equals(null)){
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
            return APIResponse.success(busInfo);

        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }

    }

    @ApiOperation(value = "查询全部Bus")
    @PostMapping(value = "/findallbus")
    public APIResponse findAllBus(@RequestBody PageHelper pageHelper, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            Page page = busInfoService.selectPage(new Page<BusInfo>(pageHelper.getCurrentPage(),pageHelper.getPageSize()),new EntityWrapper<BusInfo>());
            List list = page.getRecords();
            if (list.size()>0) {
                return APIResponse.success(list);
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR,"暂无数据");
        }

        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
    }

    @ApiOperation(value = "批量删除Bus")
    @DeleteMapping("/deletebuslist")
    public APIResponse deleteBusByid(@RequestBody @ApiParam(name = "list",value = "车牌号集合")List<String> list, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        System.out.println(list);
        try {
            String licenseNumber ="";
            boolean b = false;
            for (int i = 0; i <list.size() ; i++) {
                licenseNumber=list.get(i);
                b=busInfoService.delete(new EntityWrapper<BusInfo>().eq("license_number",licenseNumber));
            }
            if (b){
                return APIResponse.success();
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }
        return APIResponse.error(CodeEnum.DELETE_ERROR);
    }

    @ApiOperation(value = "通过车牌号修改Bus数据")
    @PutMapping("/updatebus")
    public APIResponse updateBus(@RequestBody @Validated BusInfoReq busInfoReq, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo busInfo = new BusInfo();
            BeanUtils.copyProperties(busInfoReq,busInfo);
            boolean b = busInfoService.update(busInfo,new EntityWrapper<BusInfo>().eq("license_number",busInfo.getLicenseNumber()));
            if (b){
                return APIResponse.success();
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"没有查询到修改车辆信息");
        }
        return APIResponse.error(CodeEnum.ERROR,"修改失败");
    }
}
