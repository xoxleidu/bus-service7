package com.zjts.buscenter.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.BusMaintenanceReq;
import com.zjts.buscenter.web.model.BusInfo;
import com.zjts.buscenter.web.model.FaultInfo;
import com.zjts.buscenter.web.model.MaintenanceInfo;
import com.zjts.buscenter.web.service.IBusInfoService;
import com.zjts.buscenter.web.service.IMaintenanceInfoService;
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

import java.util.List;
import java.util.Map;

/**
 * <p>
 *     保养
 *  前端控制器
 * </p>
 *
 * @author zs
 * @since 2018-10-25
 */
@Api(tags = "公交车保养信息接口",description = "公交车保养信息管理")
@RestController
@RequestMapping("/maintenanceInfo")
public class MaintenanceInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FaultInfoController.class);

    @Autowired
    private IMaintenanceInfoService maintenanceInfoService;
    @Autowired
    private IBusInfoService busInfoService;

    @ApiOperation(value = "新增保养信息")
    @PostMapping(value = "/addbusmaintenance")
    public APIResponse addBusMaintenance(@RequestBody @Validated BusMaintenanceReq busMaintenanceReq, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            MaintenanceInfo busmaintenanceInfo = new MaintenanceInfo();
            BeanUtils.copyProperties(busMaintenanceReq,busmaintenanceInfo);
            boolean b = maintenanceInfoService.insert(busmaintenanceInfo);
            if (b){
                return APIResponse.success();
            }else {
                return APIResponse.error(CodeEnum.SAVE_ERROR);
            }

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }

    @ApiOperation(value = "根据车辆id查询保养车辆信息")
    @PostMapping(value = "/findbusmaintenance")
    public APIResponse findBusMainenance(@RequestBody @ApiParam(name = "id",value = "车辆id")String id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo busInfo = busInfoService.selectById(new EntityWrapper<BusInfo>().eq("id", id));
            List<MaintenanceInfo> maintenanceInfoList = maintenanceInfoService.selectList(new EntityWrapper<MaintenanceInfo>().eq("licenseNumber",busInfo.getBusLicense()));


            if (maintenanceInfoList.size()<0&&maintenanceInfoList.equals(null)) {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
            return APIResponse.success(maintenanceInfoList);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

    @ApiOperation(value = "根据车牌号修改保养信息")
    @PostMapping(value = "/updatebusmaintenance")
    public APIResponse updateBusMaintenance(@RequestBody @Validated BusMaintenanceReq busMaintenanceReq , BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }

        try{
            MaintenanceInfo busmaintenance = new MaintenanceInfo();
            BeanUtils.copyProperties(busMaintenanceReq,busmaintenance);
            boolean b = maintenanceInfoService.update(busmaintenance,new EntityWrapper<MaintenanceInfo>().eq("licenseNumber", busmaintenance.getLicenseNumber()));
            if (b){
                return APIResponse.success();
            }
            return APIResponse.error(CodeEnum.ERROR,"修改失败");

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"修改失败");
        }
    }

    @ApiOperation(value = "根据车辆id 删除保养信息")
    @PostMapping(value = "/deletebusbymaintenanceid")
    public APIResponse deleteBusByMaintenanceid(@RequestBody @ApiParam(name = "json格式的{id: }",value = "id")JSONObject json, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }

        try{
            Integer id = (Integer) json.get("id");
           boolean b = maintenanceInfoService.delete(new EntityWrapper<MaintenanceInfo>().eq("id", id));
            if (b){
                return APIResponse.success();
            }

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }
        return APIResponse.error(CodeEnum.DELETE_ERROR);
    }


    @ApiOperation(value = "批量删除")
    @PostMapping(value = "/deletebusmaintenance")
    public APIResponse deleteBusMaintenance(@RequestBody @ApiParam(name = "list",value = "id集合")Map<String,List<Integer>> idMap, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }

        try{
            List<Integer> idList = idMap.get("id");
            boolean b = false;
            for (int i = 0; i < idList.size(); i++) {
                b = maintenanceInfoService.delete(new EntityWrapper<MaintenanceInfo>().eq("id", idList.get(i)));
            }
            if (b){
                return APIResponse.success();
            }

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }
        return APIResponse.error(CodeEnum.DELETE_ERROR);
    }
}
