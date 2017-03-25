package com.brianway.learning.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public class ZipFileUtil {
    public static void zipFiles(List<File> files) throws Exception {
        String zipFileName = UUID.randomUUID().toString() + ".zip";

        String outFilePath = "d:/";

        File zipFile = new File(outFilePath + zipFileName);

        FileOutputStream outputStream = new FileOutputStream(zipFile);

        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);

        }
    }

    public static void zipFile(File file, ZipOutputStream zipOutputStream) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    FileInputStream inputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputFile = new BufferedInputStream(inputStream);
                    ZipEntry entry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(entry);

                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bufferedInputFile.available();
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE);
                    leaveByte = (int) streamTotal % MAX_BYTE;

                    if (streamNum > 0){
                        for (int j = 0; j < streamNum; ++j){
                            inOutbyte = new byte[MAX_BYTE];

                            bufferedInputFile.read(inOutbyte,0,MAX_BYTE);
                            zipOutputStream.write(inOutbyte,0,MAX_BYTE);
                        }
                        // 写出剩下的流数据
                        inOutbyte = new byte[leaveByte];
                        bufferedInputFile.read(inOutbyte, 0, leaveByte);
                        zipOutputStream.write(inOutbyte);
                        zipOutputStream.closeEntry(); // Closes the current ZIP entry
                        // and positions the stream for
                        // writing the next entry
                        bufferedInputFile.close(); // 关闭
                        inputStream.close();
                    }

                }
            } else {
                throw new Exception("文件不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file1 = new File("d:/1.txt");
        File file2 = new File("d:/2.txt");
        File file3 = new File("d:/3.txt");

        List<File> list = new ArrayList<>();
        list.add(file1);
        list.add(file2);
        list.add(file3);

        try {
            ZipFileUtil.zipFiles(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
