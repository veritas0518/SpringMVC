package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/1 14:32
 **/

@Controller
public class HelloController { //左边绿色这个小图标表示当前这个类的对象已经交给了IOC容器来管理了

    // "/"--> /WEB-INF/templates/index.html

    @RequestMapping("/") //请求映射
    public String index(){
        //返回视图名称(去掉前缀，去掉后缀)
        return "index";
    }

    @RequestMapping("/target") //和请求地址保持一致
    public String toTarget(){
        return "target";
    }
}
