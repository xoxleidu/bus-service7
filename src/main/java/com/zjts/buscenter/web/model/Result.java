/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Result
 * Author:   XBAO
 * Date:     2018/10/30 20:01
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
public class Result {

    private String token;
    private String avatar;
    private String name;
    private Roles roles;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

}