package com.getnovel.common.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/*Annotation所修饰的对象范围：ElementType.METHOD 描述方法，ElementType.TYPE 描述类、接口接口(包括注解类型) 或enum声明*/
@Target({ElementType.METHOD,ElementType.TYPE})
/*该Annotation被保留的时间长短:RetentionPoicy取值有：1.SOURCE:在源文件中有效（即源文件保留）
  2.CLASS:在class文件中有效（即class保留）3.RUNTIME:在运行时有效（即运行时保留）*/
@Retention(RetentionPolicy.RUNTIME)
@Mapping
/*用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化*/
@Documented
/**
 * 对接口接收的数据进行AES解密的注解
 * */
public @interface SecurityParameter {

    /**
     * 入参是否解密，默认解密
     */
    boolean inDecode() default true;

}