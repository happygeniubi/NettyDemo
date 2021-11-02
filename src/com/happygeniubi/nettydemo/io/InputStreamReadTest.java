package com.happygeniubi.nettydemo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// 字节流转字符流
public class InputStreamReadTest {
    public static void main(String[] args) throws Exception{
        Test("C:\\Users\\spinach\\Desktop\\R.txt");
    }

    public static void Test(String path) throws Exception {
        // 读取字节流
        InputStream inputStream = new FileInputStream(path);

        // 读取字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        inputStream.close();
        bufferedReader.close();
    }
}
