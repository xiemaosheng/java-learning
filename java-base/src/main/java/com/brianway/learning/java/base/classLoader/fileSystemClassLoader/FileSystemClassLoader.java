package com.brianway.learning.java.base.classLoader.fileSystemClassLoader;

import java.io.*;

/** 文件系统加载器
 * Created by xms on 2017/7/2 0002.
 */
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(ClassLoader parent, String rootDir) {
        super(parent);
        this.rootDir = rootDir;
    }

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream inputStream = new FileInputStream(path);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int bytesSize = 4096;
            byte[] buffer = new byte[bytesSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesNumRead);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separator + className.replace('.', File.separatorChar) + ".class";
    }
}
