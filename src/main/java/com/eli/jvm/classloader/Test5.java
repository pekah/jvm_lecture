package com.eli.jvm.classloader;

import java.util.Random;

/**
 * Created by zhouyilin on 2018/4/16.
 *
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用父接口的时候（如引用接口中定义的常量时），才会初始化
 */
public class Test5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    public static int a = new Random().nextInt(3);
}

interface MyChild5 extends MyParent5 {
    public static int b = new Random().nextInt(4);
}