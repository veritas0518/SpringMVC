package com.spring.mvc.controller;

import com.spring.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @ClassName: ParamController
 * @Description: 获取请求功能参数
 * @Author: TianXing.Xue
 * @Date: 2021/10/2 10:34
 **/

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            //required：是否必须传输value所对应的请求参数
            //默认值为true，代表着必须要传；false代表有则赋值，没有就默认值null
            @RequestParam(value = "user_name", required = false, defaultValue ="hehe") String username, //将请求参数和形参创建映射关系
            String password,
            String[] hobby,
            @RequestHeader(value = "sayHaha",required = false,defaultValue = "HAHA")String host, //从请求头信息中找到Host对应的信息，再赋值给形参host
            @CookieValue("JSESSIONID") String JSESSIONID) {
        //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置一个字符串类型，或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:" + username + ",password:" + password + ",hobby" + Arrays.toString(hobby));
        System.out.println("Host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }

}
