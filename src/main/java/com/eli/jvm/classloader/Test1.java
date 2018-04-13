package com.eli.jvm.classloader;

/**
 *
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕
 *
 * 由于首次主动使用类时才会被初始化，因此同时打印str和str2时，MyParent1 static block只会打印一次
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
//        System.out.println("----");
//        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}