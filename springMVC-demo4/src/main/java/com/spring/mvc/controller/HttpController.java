package com.spring.mvc.controller;

import com.spring.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HttpController
 * @Description: 测试报文信息
 * @Author: TianXing.Xue
 * @Date: 2021/10/6 16:53
 **/
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){

        //当前requestEntity表示整个请求报文的信息
        System.out.println("请求头："+requestEntity.getHeaders());
        System.out.println("请求体："+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws Exception{
        //getWriter().write()：以流的方式去写，方法必须满足流的要求
        //getWriter().print()：可以响应任意的数据
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",23,"男");
    }

    /*
      ** ajax是页面不发生跳转的情况下与服务器进行交互 **
     */
    @RequestMapping("/testAxios")
    @ResponseBody //这个方法的返回值就是响应到浏览器的数据
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }
}
