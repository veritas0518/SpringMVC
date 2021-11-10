package com.mavenproject_xtx;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: TestHelloMaven
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/9/30 19:46
 **/

public class TestHelloMaven {

    @Test
    public void testAdd(){
        System.out.println("====testAdd=====");
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);

        //判断结果是否正确
        Assert.assertEquals(30,res);

    }
}
