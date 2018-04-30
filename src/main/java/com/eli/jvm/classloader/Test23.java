package com.eli.jvm.classloader;

/**
 * Created by zhouyilin on 2018/4/30.
 */
public class Test23 {
    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemClassLoader().getClass().getClassLoader());
    }
}
