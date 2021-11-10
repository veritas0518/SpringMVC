package com.mavenproject_xtx;

/**
 * @ClassName: HelloMaven
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/9/30 19:43
 **/

public class HelloMaven {
    public int add(int n1,int n2){
        return n1+n2;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);
        System.out.println("10+20="+res);
        System.out.println("10+20=124"+res);
        System.out.println("javase_maven test"+res);
    }
}
