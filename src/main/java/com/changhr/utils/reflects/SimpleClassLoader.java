package com.changhr.utils.reflects;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Set;

/**
 * @author changhr
 * @create 2019-11-22 15:55
 */
public class SimpleClassLoader extends ClassLoader {

    /**
     * 用于读取 .class 文件的路径
     */
    private String swapPath;

    /**
     * 用于标记这些 name 的类是先由自身加载的
     */
    private Set<String> useMyClassLoaderLoad;

    public SimpleClassLoader(String swapPath, Set<String> useMyClassLoaderLoad) {
        this.swapPath = swapPath;
        this.useMyClassLoaderLoad = useMyClassLoaderLoad;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("load class [" + name + "]");
        Class<?> c = findLoadedClass(name);
        if (c == null && useMyClassLoaderLoad.contains(name)) {
            // 特殊的类让我自己加载
            c = findClass(name);
            if (c != null) {
                return c;
            }
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("find class [" + name + "]");
        // 根据文件系统路径加载 class 文件，并返回 byte 数组
        byte[] classBytes = getClassByte(name);
        // 调用 ClassLoader 提供的方法，将二进制数组转换成 Class 类的实例
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] getClassByte(String name) {
        String className = name.substring(name.lastIndexOf('.') + 1, name.length()) + ".class";
        System.out.println("get class byte array by file [" + swapPath + className + "]");
        try {
            FileInputStream fileInputStream = new FileInputStream(swapPath + className);
            byte[] buffer = new byte[1024];
            int length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((length = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }
}
