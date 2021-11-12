package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/9 18:49
 **/

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
