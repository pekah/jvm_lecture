package com.eli.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zhouyilin on 2018/4/26.
 */
public class Test16 extends ClassLoader{

    private String classLoaderName;
    private String fileExtension = ".class";

    public Test16(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test16(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public static void main(String[] args) throws Exception {
        Test16 test16 = new Test16("myLoader");
        test(test16);
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] classData = loadClassData(className);

        return this.defineClass(className, classData, 0, classData.length);
    }

    private byte[] loadClassData(String className) {
        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");

            inputStream = new FileInputStream(className + this.fileExtension);
            byteArrayOutputStream = new ByteArrayOutputStream();

            int ch;

            while (-1 != (ch = inputStream.read())){
                byteArrayOutputStream.write(ch);
            }

            data = byteArrayOutputStream.toByteArray();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return data;
    }

    public static void test (ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.eli.jvm.classloader.Test15");
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }
}
