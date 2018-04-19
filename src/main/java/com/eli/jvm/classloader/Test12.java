package com.eli.jvm.classloader;

/**
 * Created by zhouyilin on 2018/4/19.
 *
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class Test12 {
    public static void main(String[] args) throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.eli.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("------");

        clazz = Class.forName("com.eli.jvm.classloader.CL");

        System.out.println(clazz);


    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}