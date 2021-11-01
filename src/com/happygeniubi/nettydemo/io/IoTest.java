package com.happygeniubi.nettydemo.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Java采用unicode来表示字符，java中的一个char是2个字节，一个中文或英文字符的unicode编码都占2个字节，但如果采用其他编码方式，一个字符占用的字节数则各不相同。
 * 在 GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，一个汉子字符存储需要2个字节。
 * 在UTF-8编码中，一个英文字母字符存储需要1个字节，一个汉字字符储存需要3到4个字节。
 * 在UTF-16编码中，一个英文字母字符存储需要2个字节，一个汉字字符储存需要3到4个字节（Unicode扩展区的一些汉字存储需要4个字节）。
 * 在UTF-32编码中，世界上任何字符的存储都需要4个字节。
 */
public class IoTest {
    public static void main(String[] args) throws IOException {

        String dir = "C:\\Users\\spinach\\Desktop";
        String name = "草稿.txt";
        File file = new File(dir, name);
        //　文件流
        FileInputStream fileInputStream = new FileInputStream(file);

//        testRead(fileInputStream);
//        testSkip(fileInputStream);
        testReadByteArr(fileInputStream);

    }

    // 取文件里面第一个字节以及对应编码
    public static void testRead(InputStream inputStream) throws IOException {

        // 对于汉字等unicode中的字符不能正确读取,因为中文字符不止一个字节,只能以乱码形式显示.
        int read = inputStream.read();
        // 文件第一个字节
        System.out.println(read);
        // 对应编码
        System.out.println((char) read);
    }

    // 跳过几个字节
    public static void testSkip(InputStream inputStream) throws IOException {
        // 跳过两个字节之后再进行读取操作
        long skip = inputStream.skip(2);
        System.out.println(skip);

        int read = inputStream.read();
        System.out.println(read);
        System.out.println((char) read);
    }

    // 读取定量的字节
    public static void testReadByteArr(InputStream inputStream) throws IOException {

        // 如果buf的长度为0,则不读取任何字节并返回0,每次读取的字节数最多等于buf的长度.
//        byte[] buf = new byte[1024];
        byte[] buf = new byte[inputStream.available()];

        int length;

        // 循环读取文件内容, 输入流中将最多buf.length个字节读入一个buf数组中, 返回类型是读取到的字节数
        while((length = inputStream.read(buf)) != -1) {
            System.out.println("读取到的字节数:" + length);
            System.out.println(new String(buf, 0 ,length));
            // 中文乱码的话需要设置一下编码规则
            // System.out.println(new String(buf, 0 ,length, StandardCharsets.UTF_8));
        }
    }
}
