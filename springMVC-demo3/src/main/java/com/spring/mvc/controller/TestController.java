package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Description: 专门实现页面跳转的
 * @Author: TianXing.Xue
 * @Date: 2021/10/3 17:18
 **/
@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String test_view() {
        return "test_view";
    }
}
