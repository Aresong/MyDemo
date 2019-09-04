package com.s5.spring.demo3;

import org.aspectj.lang.JoinPoint;

/**
 * 切面类
 **/
public class MyAspectXML {
    public void checkPri(JoinPoint joinPoint) {
        System.out.println("前权限校验……" + joinPoint);
    }

}
