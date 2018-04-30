package com.eli.jvm.classloader;

import java.lang.reflect.Method;

/**
 * Created by zhouyilin on 2018/4/29.
 */
public class Test20 {
    public static void main(String[] args) throws Exception {
        Test16 loader1 = new Test16("loader1");
        Test16 loader2 = new Test16("loader2");

        loader1.setPath("/Users/zhouyilin/Desktop/test/");
        loader2.setPath("/Users/zhouyilin/Desktop/test/");

        Class<?> clazz1 = loader1.loadClass("com.eli.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.eli.jvm.classloader.MyPerson");

        /*
          clazz1和clazz2都是由系统类加载器加载，因此true
          如果把clazz1和clazz2都从classpath下删除，去加载桌面的class文件，那么loader1和loader2会处于不同的命名空间
          这时候会打印false，并且调用
               Method method = clazz1.getMethod("setMyPerson", Object.class);
               method.invoke(object1, object2);
          会抛异常。原因是不同命名空间的类加载器所加载的类相互不可见。
         */
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);


    }
}
