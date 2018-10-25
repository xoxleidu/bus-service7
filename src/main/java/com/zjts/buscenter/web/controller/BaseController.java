package com.zjts.buscenter.web.controller;

import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.util.ValidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

public class BaseController {


    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 参数验证
     * @param bindingResult
     * @return
     */
    protected APIResponse parameterVerification(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("数据绑定错误："
                    + ValidUtils.getBindErrorMessageOne(bindingResult));
            return APIResponse.error(CodeEnum.REQ_VERIFICATION_ERROR, ValidUtils
                    .getBindErrorMessageOne(bindingResult));
        }
        return null;
    }
}