package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ViewController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/4 14:54
 **/
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    //转发(地址栏显示的是/testForward,但是最终的页面是success成功页面)
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    //WEB-INF下的内容不能被重定向访问
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
