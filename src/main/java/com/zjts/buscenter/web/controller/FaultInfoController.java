package com.zjts.buscenter.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.BusFaultReq;
import com.zjts.buscenter.web.model.BusInfo;
import com.zjts.buscenter.web.model.FaultInfo;
import com.zjts.buscenter.web.service.IBusInfoService;
import com.zjts.buscenter.web.service.IFaultInfoService;
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
 *     故障
 *  前端控制器
 * </p>
 *
 * @author zs
 * @since 2018-10-25
 */

@Api(tags = "公交车故障接口",description = "公交故障信息管理")
@RestController
@RequestMapping(value = "/faultInfo",produces = "application/json")
public class FaultInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FaultInfoController.class);

    @Autowired
    private IFaultInfoService faultInfoService;
    @Autowired
    private IBusInfoService busInfoService;


    @ApiOperation(value = "新增故障信息")
    @PostMapping(value = "/addfault")
    public APIResponse addFault(@RequestBody @Validated BusFaultReq busFaultReq, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }

        try {
            FaultInfo busFault = new FaultInfo();
            BeanUtils.copyProperties(busFaultReq, busFault);

            boolean b = faultInfoService.insert(busFault);
            FaultInfo faultInfo = faultInfoService.selectOne(new EntityWrapper<FaultInfo>().eq("license_number", busFault.getLicenseNumber()));
            if (b) {
                return APIResponse.success(faultInfo.getId());
            }
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }

    @ApiOperation(value = "根据车辆id查询故障信息")
    @PostMapping(value = "/findbusfault")
    public APIResponse findBusFault(@RequestBody @ApiParam(name = "id",value = "车辆id")String id , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            BusInfo busInfo = busInfoService.selectOne(new EntityWrapper<BusInfo>().eq("id", id));
            List<FaultInfo> faultList = faultInfoService.selectList(new EntityWrapper<FaultInfo>().eq("license_number", busInfo.getLicenseNumber()));

            if (faultList.size()<0&&faultList.equals(null)) {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
            return APIResponse.success(faultList);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

    @ApiOperation(value = "根据车牌号修改故障信息")
    @PostMapping(value = "/updatebusfault")
    public APIResponse updateBusFault(@RequestBody @Validated BusFaultReq busFaultReq , BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            FaultInfo busFault = new FaultInfo();
            BeanUtils.copyProperties(busFaultReq,busFault);

            boolean b = faultInfoService.update(busFault, new EntityWrapper<FaultInfo>().eq("license_number", busFault.getLicenseNumber()));
            if (b){
                return APIResponse.success();
            }

            return APIResponse.error(CodeEnum.ERROR,"没有查询到修改车辆故障信息");

        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR,"修改失败");
        }
    }

    @ApiOperation(value = "根据id删除故障信息")
    @PostMapping(value = "/deletebusbyfaultId")
    public APIResponse deleteBusByFaultId(@RequestBody @ApiParam(name = "json格式的{id: }",value = "id")JSONObject json, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            Integer id = (Integer) json.get("id");
            boolean b = faultInfoService.deleteById(new EntityWrapper<FaultInfo>().eq("id", id));
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
    @PostMapping(value = "/deletebusfault")
    public APIResponse deleteBusFault(@RequestBody @ApiParam(name = "list",value = "id集合")Map<String,List<Integer>> idMap, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            List<Integer> idList = idMap.get("id");
            boolean b = false;
            for (int i = 0; i < idList.size(); i++) {
                b = faultInfoService.delete(new EntityWrapper<FaultInfo>().eq("id", idList.get(i)));
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
