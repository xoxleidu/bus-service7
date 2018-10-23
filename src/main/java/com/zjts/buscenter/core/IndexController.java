package com.zjts.buscenter.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping()
public class IndexController {

    @RequestMapping("index")
    public String index(){
        int a = 10;
        int b = a/0;
        return "index";
    }
}
