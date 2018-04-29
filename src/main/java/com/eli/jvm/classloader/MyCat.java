package com.eli.jvm.classloader;

/**
 * Created by zhouyilin on 2018/4/29.
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());

        System.out.println("from MyCat : " + MySample.class);
    }
}
