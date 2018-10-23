package com.zjts.buscenter.core.common.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  全局异常的拦截器
 * @author han zq
 *  * @date 2018.10.23
 */
@Controller
@RequestMapping("/error")
public class ControllerExceptionHandler  {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 拦截运行时异常
     */
    @RequestMapping("/500")
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String runtimeInterceptor(RuntimeException e){
        logger.error("运行时异常:", e);
        return "500";
    }
}
