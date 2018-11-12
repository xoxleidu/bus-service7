package com.zjts.buscenter.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationInfo;
import com.zjts.buscenter.web.service.IRouteInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@Api(tags = "路线信息", description = "查询所有路线")
@RestController
@RequestMapping(value = "/routeInfo", produces = "application/json")
public class RouteInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RouteInfoController.class);

    @Autowired
    private IRouteInfoService routeInfoService;

    @ApiOperation(value = "根据线路名/站点名 查询所有路线")
    @PostMapping(value = "/findAllRoute")
    public APIResponse findAllRoute(@RequestBody @Validated String routeName, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            JSONObject jsonObject = routeInfoService.findRoute(routeName);
            System.err.println(jsonObject);
            return APIResponse.success(jsonObject);
        } catch (Exception e) {
            logger.error("出现异常 : " + e.getMessage());
            e.printStackTrace();

            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }

    }

    @ApiOperation(value = "根据站点索引，线路名 查询所有站点")
    @PostMapping(value = "/findUpDownStation")
    public APIResponse findUpDownStation(@RequestBody @Validated JSONObject jsonObject, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            String routName = String.valueOf(jsonObject.get("routeName"));
            String stationIndex = String.valueOf(jsonObject.get("stationIndex"));
            JSONObject upDownStation = routeInfoService.findUpDownStation(routName, stationIndex);

            if (upDownStation !=null){
                return APIResponse.success(upDownStation);
            }else {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
        }catch (Exception e){
            logger.error("出现异常 : " + e.getMessage());
            e.printStackTrace();

            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }


    @ApiOperation(value = "根据上下行状态查询所有站点")
    @PostMapping(value = "/findStation")
    public APIResponse findStation(@RequestBody @Validated JSONObject jsonObject, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            String routeName = (String) jsonObject.get("routeName");
            String state = (String) jsonObject.get("state");
            JSONObject stationJson = routeInfoService.findStationInfo(routeName, state);
            if (stationJson!=null){
                return APIResponse.success(stationJson);
            }else {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
        }catch (Exception e){
            logger.error("出现异常 : " + e.getMessage());
            e.printStackTrace();

            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

}

