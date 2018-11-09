/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-06
 * Time: 15:43
 */
package com.zjts.buscenter.web.controller;



import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "ceshi",description = "ceshi")
@RestController
@RequestMapping(value = "/GpsInfoController",produces = "application/json")
public class GpsInfoController {

    private static final Logger logger = LoggerFactory.getLogger(GpsInfoController.class);

}
