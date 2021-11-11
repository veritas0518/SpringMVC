package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/1 16:46
 **/

@Controller
public class TestController {
    /*
        当浏览器发送请求到服务器时，DispatcherServlet接收到了请求后，
        将请求地址和控制器方法所使用的RequestMapping的value属性值进行匹配
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }
}
