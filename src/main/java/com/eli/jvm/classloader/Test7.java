package com.eli.jvm.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyilin on 2018/4/18.
 */
public class Test7 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader()); // 启动类加载器可能返回null

        Class<?> clazz2 = Class.forName("com.eli.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader()); // C类放在classpath下，由系统（或称为应用类）类加载器加载

    }
}

class C {

}