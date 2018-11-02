/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-24
 * Time: 13:37
 */
package com.zjts.buscenter.web.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
            //DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            bus.setRegistrationDate(new Date());

            boolean b = busInfoService.insert(bus);
            BusInfo busInfo = busInfoService.selectOne(new EntityWrapper<BusInfo>().eq("license_number",bus.getLicenseNumber()));
            if (b){
                return APIResponse.success(bus.getId());
            }else {
                return APIResponse.error(CodeEnum.SAVE_ERROR);
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }

    @ApiOperation(value = "通过id查找单一Bus")
    @PostMapping(value = "/findbusbyid")
    public APIResponse findBusByid(@RequestBody @ApiParam(name = "id",value = "车辆id") String id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo busInfo = busInfoService.selectOne(new EntityWrapper<BusInfo>().eq("id",id));

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
                return APIResponse.success(page);
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR,"暂无数据");
        }

        return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
    }

    @ApiOperation(value = "通过id批量删除Bus")
    @PostMapping("/deletebusidlist")
    public APIResponse deleteBusByid(@RequestBody @ApiParam(name = "list",value = "车辆id集合")Map<String,List<Integer>> idMap, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }

        try {
            List<Integer> idList = idMap.get("id");
            boolean b = false;
            for (int i = 0; i < idList.size(); i++) {
               b = busInfoService.deleteById(idList.get(i));

               System.out.println(idList.get(i));
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


    @ApiOperation(value = "通过id删除单一Bus")
    @PostMapping("/deletebusbyid")
    public APIResponse deleteBusById(@RequestBody @ApiParam(name = "id",value = "车辆id")JSONObject json, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            Integer id = (Integer) json.get("id");
            boolean b = busInfoService.deleteById(id);
            if(b){
                return APIResponse.success();
            }else {
                return APIResponse.error(CodeEnum.DELETE_ERROR);
            }
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }

    }

    @ApiOperation(value = "通过车辆id修改Bus数据")
    @PostMapping("/updatebus")
    public APIResponse updateBus(@RequestBody @Validated BusInfoReq busInfoReq, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            if (busInfoReq.getId()!=null) {
                BusInfo busInfo = new BusInfo();
                BeanUtils.copyProperties(busInfoReq, busInfo);
                boolean b = busInfoService.update(busInfo, new EntityWrapper<BusInfo>().eq("id", busInfo.getId()));
                if (b) {
                    return APIResponse.success(busInfo.getId());
                }
            }else {
                return APIResponse.error(CodeEnum.ERROR,"id不能为空");
            }
        } catch (Exception e) {
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"没有查询到修改车辆信息");
        }
        return APIResponse.error(CodeEnum.ERROR,"修改失败");
    }
}
