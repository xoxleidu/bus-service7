package com.zjts.buscenter.web.controller;

import com.zjts.buscenter.web.model.ResData;
import com.zjts.buscenter.web.model.Result;
import com.zjts.buscenter.web.model.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 驾驶员的基本信息表 前端控制器
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    @ResponseBody
    public ResData login() {
        System.out.println("login");
        //System.out.println(user.getUsername());
        //System.out.println(user.getPassword());
        Result data = new Result();
        data.setToken("admin");
        ResData resdata = new ResData();
        resdata.setData(data);
        resdata.setCode("000");
        resdata.setMessage("ok");

        String res = "{data:[{token:'admin',code:20000,message:'ere'}]}";

        return resdata;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResData info() {
        System.out.println("info");

        Roles roles = new Roles();
        roles.setRoles("admin");
        Result data = new Result();
        data.setAvatar("");
        data.setName("admin");
        data.setRoles(roles);
        ResData resdata = new ResData();
        resdata.setData(data);
        resdata.setCode("000");
        resdata.setMessage("ok");
        return resdata;
    }


}
