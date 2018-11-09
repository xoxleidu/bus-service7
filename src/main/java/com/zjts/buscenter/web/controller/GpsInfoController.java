/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-06
 * Time: 15:43
 */
package com.zjts.buscenter.web.controller;


import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.common.model.req.BusFaultReq;
import com.zjts.buscenter.web.dao.GpsInfoMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.service.Impl.GpsInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@Api(tags = "ceshi",description = "ceshi")
@RestController
@RequestMapping(value = "/GpsInfoController",produces = "application/json")
public class GpsInfoController {

    private static final Logger logger = LoggerFactory.getLogger(FaultInfoController.class);

    @Autowired
    private GpsInfoServiceImpl gpsInfoService;


}
