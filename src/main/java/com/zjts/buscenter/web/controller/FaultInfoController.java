package com.zjts.buscenter.web.controller;


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
            //faultInfoService.selectOne(new EntityWrapper<BusInfo>(busFault))
            if (b) {
                return APIResponse.success();
            }
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }

    @ApiOperation(value = "根据车牌号查询故障信息")
    @PostMapping(value = "/findbusfault")
    public APIResponse findBusFault(@RequestBody @ApiParam(name = "licenseNumber",value = "车牌号")String licenseNumber , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {

            //子查询 还没做
            FaultInfo faultInfo = faultInfoService.selectOne(new EntityWrapper<FaultInfo>().eq("license_number", licenseNumber));


            if (faultInfo.equals(null)) {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
            return APIResponse.success(faultInfo);
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

    @ApiOperation(value = "根据车牌号修改故障信息")
    @PutMapping(value = "/updatebusfault")
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

    @ApiOperation(value = "/批量删除")
    @DeleteMapping(value = "/deletebusfault")
    public APIResponse deleteBusFault(@RequestBody @ApiParam(name = "list",value = "车牌号集合")List<String> list, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            String licenseNumber ="";
            boolean b = false;
            for (int i = 0; i < list.size(); i++) {
                licenseNumber=list.get(i);
                b = faultInfoService.delete(new EntityWrapper<FaultInfo>().eq("license_number", licenseNumber));
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
