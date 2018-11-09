package com.zjts.buscenter.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.gson.JsonObject;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.RouteInfoReq;
import com.zjts.buscenter.util.BeanUtil;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import com.zjts.buscenter.web.service.IRouteInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @ApiOperation(value = "根据线路名查询所有路线")
    @PostMapping(value = "/findAllRouteByrouteName")
    public APIResponse findAllRoute(@RequestBody @Validated String routeName, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            JSONObject jsonObject = routeInfoService.findStationName(routeName);
            System.out.println(jsonObject);
            Integer upStartIndex = Integer.parseInt((String) jsonObject.get("upStartIndex"));
            Integer upLastIndex = Integer.parseInt((String) jsonObject.get("upLastIndex"));
            Integer downStartIndex = Integer.parseInt((String) jsonObject.get("downStartIndex"));
            Integer downLastIndex = Integer.parseInt((String) jsonObject.get("downLastIndex"));
            /*Integer upLastIndex = (Integer) jsonObject.get("upLastIndex");
            Integer downStartIndex = (Integer) jsonObject.get("downStartIndex");
            Integer downLastIndex = (Integer) jsonObject.get("downLastIndex");*/

            List<StationInfo> stationInfoList = routeInfoService.findStationInfo((String) jsonObject.get("name"));

            for (int i = 0; i <stationInfoList.size() ; i++) {
                if (i==upStartIndex){
                    jsonObject.put("upStartIndex",stationInfoList.get(i).getStationName());
                }
                if(i==upLastIndex){
                    jsonObject.put("upLastIndex",stationInfoList.get(i).getStationName());
                }
                if (i==downStartIndex){
                    jsonObject.put("downStartIndex",stationInfoList.get(i).getStationName());
                }
                if (i==downLastIndex){
                    jsonObject.put("downLastIndex",stationInfoList.get(i).getStationName());
                }

            }

            return APIResponse.success(jsonObject);
        } catch (Exception e) {
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
            String routeName = (String) jsonObject.get("name");
            String state = (String) jsonObject.get("state");
            List<StationInfo> stationInfoList = routeInfoService.findStationInfo(routeName, state);

            JSONObject json = new JSONObject();
            RouteInfo routeInfo = routeInfoService.selectOne(new EntityWrapper<RouteInfo>().eq("route_name", routeName));
            json.put("name",routeName);
            json.put("startTime",routeInfo.getUpstartTime());
            json.put("endTime",routeInfo.getDownlastTime());
            json.put("stationList",stationInfoList);
            if (stationInfoList.size() > 0 && stationInfoList != null) {
                return APIResponse.success(json);
            } else {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
        }catch (Exception e){
            logger.error("出现异常 : " + e.getMessage());
            e.printStackTrace();

            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

    @ApiOperation(value = "查询车辆最新数据")
    @PostMapping(value = "/findBusByRouteID")
    public APIResponse findBusByRouteID(@RequestBody @ApiParam(name = "routeId",value = "线路id") String routeId, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            List<GpsInfo> bus = routeInfoService.findBusByRouteID(routeId);

            if (bus.size()>0&&bus!=null){
                return APIResponse.success(bus);
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

