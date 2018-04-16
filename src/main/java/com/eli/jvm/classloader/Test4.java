package com.eli.jvm.classloader;

/**
 * 
 *
 */
public class Test4 {

    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
