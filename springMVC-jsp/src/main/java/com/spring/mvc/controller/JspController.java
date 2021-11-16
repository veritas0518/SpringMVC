package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: JspController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/4 17:56
 **/
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
