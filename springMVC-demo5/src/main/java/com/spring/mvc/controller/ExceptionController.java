package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName: ExceptionController
 * @Description: 异常控制器
 * @Author: TianXing.Xue
 * @Date: 2021/10/9 16:08
 **/

@ControllerAdvice
public class ExceptionController {

    //如果当前出现了value数组中定义的任意一个异常，就会通过下面注解所标识的方法来作为新的控制器方法来执行
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
