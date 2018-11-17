/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-15
 * Time: 16:46
 */
package com.zjts.buscenter.web.controller;


import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.web.model.Line;
import com.zjts.buscenter.web.model.Station;
import com.zjts.buscenter.web.service.ILineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "微信", description = "小程序接口")
@RestController
@RequestMapping(value = "/wxController", produces = "application/json")
public class wxController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(wxController.class);

    @Autowired
    private ILineService lineService;


    @ApiOperation(value = "根据线路名/站点名 查询所有路线")
    @PostMapping(value = "/findAllLine")
    public APIResponse findAllLine(@RequestBody @Validated String lineName, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            List<JSONObject> jsonList = lineService.findLineBylineName(lineName);
            if (jsonList!=null&&jsonList.size()>0){
                return APIResponse.success(jsonList);
            }else {
                return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
            }
        } catch (Exception e) {
            logger.error("出现异常 : " + e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
    }

    @ApiOperation(value = "根据跑法号 查询所有站点")
    @PostMapping(value = "/findAllStation")
    public APIResponse findAllStation(@RequestBody @Validated String runMethod, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try{
            List<Station> allStationAndBus = lineService.findAllStationAndBus(runMethod);
            if (allStationAndBus!=null&&allStationAndBus.size()>0){
                return APIResponse.success(allStationAndBus);
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
