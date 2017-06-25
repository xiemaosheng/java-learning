package com.brianway.learning.java.base.classLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

/**
 * 热替换实现
 * Created by xms on 2017/6/25 0025.
 */
public class HotSwapCL extends ClassLoader {
    private String basedir;        // 需要该类加载器直接加载的类文件的基目录
    private HashSet dynaclazns;    // 需要该类加载器直接加载的的类名

    public HotSwapCL(String basedir, String[] clazns) {
        super(null);               // 指定父类加载器为null
        this.basedir = basedir;
        this.dynaclazns = new HashSet();
        loadClassByMe(clazns);
    }

    private void loadClassByMe(String[] clazns) {
        for (String clz : clazns){
            loadDirectly(clz);
            dynaclazns.add(clz);
        }
    }

    private Class loadDirectly(String name){
        Class clz = null;
        StringBuilder sb = new StringBuilder(basedir);
        String className = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + className);
        File classFile = new File(sb.toString());

        return clz;
    }

    private Class instanceClass(String name, InputStream is,long len){
        byte[] raw = new byte[(int)len];
        try {
            is.read(raw);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return defineClass(name,raw,0,raw.length);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class clz = null;
        clz = findLoadedClass(name);
        if (!this.dynaclazns.contains(name) && clz == null){
            clz = getSystemClassLoader().loadClass(name);
        }
        if (clz == null){
            throw new ClassNotFoundException(name);
        }
        if (resolve){
            resolveClass(clz);
        }

        return clz;
    }
}
