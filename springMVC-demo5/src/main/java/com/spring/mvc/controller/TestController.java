package com.spring.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/8 15:49
 *
 *   重要概念！！！
 *   先写dao层：连接数据库
 *   再写service层：调用dao层去写一些具体的业务，但它只管业务
 *   servlet层：接收前端的数据，把数据交给service层去处理，service返回的结果调用控制的界面，再跳转过去
 *   vo：视图层的对象，它还是一个实体类，只不过细分了，拆掉了一些不必要的东西
 *   dto：数据传输时的对象
 **/
@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }
}
