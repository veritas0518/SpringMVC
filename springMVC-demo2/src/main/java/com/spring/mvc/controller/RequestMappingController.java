package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: RequestMappingController
 * @Description: get请求没有请求体，post请求有请求体
 * @Author: TianXing.Xue
 * @Date: 2021/10/1 17:08
 **/

@Controller
//类上是请求映射的初始信息
//@RequestMapping("/hello")
public class RequestMappingController {

    //方法上是请求映射的具体信息
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(value = "/testParamsAndHeaders", //value只要匹配其中一个就行
            params = {"username", "password=123456"}, //params必须两个都要匹配
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders() {
        return "success";
    }

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt") //ant风格
    public String testAnt() {
        return "success";
    }

    //restful风格
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ",username=" + username);
        return "success";
    }
}
