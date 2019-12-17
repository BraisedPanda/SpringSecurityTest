package com.braisedpanda.web.iotest;

import org.junit.Test;

import java.io.*;


/**
 * @program: admin-dashboard
 * @description: 测试练习java IO
 * @author: chenzhen
 * @create: 2019-11-28 14:10
 **/
public class IOTest {
   private String sourceFile = "E:/test/a.txt";
   private String copyFile = "E:/test/b.txt";

    private String sourceFile2 = "E:/test/a.png";
    private String copyFile2 = "E:/test/b.png";

    /**测试BufferefReader & BufferedWriter  [字符]
     * 读取图片格式失效
     * **/
    @Test
    public void copyFile1() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(copyFile));
        char[] chs = new char[1024];
        int len = 0;
        while((len = reader.read(chs)) != -1){
            writer.write(chs,0,len);

        }

        reader.close();
        writer.close();

    }

    /**BufferedInputStream & BufferedOutputStream  [字节]
     * 读取图片格式失效
     * **/
    @Test
    public void copyFile2() throws IOException{
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile2));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(copyFile2));
        int len = 0;
        byte[] chn = new byte[1024];
        while((len = inputStream.read(chn))!=-1){
            outputStream.write(chn,0,len);
        }
        outputStream.close();
        inputStream.close();

    }


}
