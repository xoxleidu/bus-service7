/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ResData
 * Author:   XBAO
 * Date:     2018/10/30 19:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zjts.buscenter.web.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author XBAO
 * @create 2018/10/30
 * @since 1.0.0
 */
public class ResData {

    private String code;
    private String message;
    private Result data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getData() {
        return data;
    }

    public void setData(Result data) {
        this.data = data;
    }

}