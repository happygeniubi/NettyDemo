package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

// 字符流转字节流
public class OutputStreamWriteTest {
    public static void main(String[] args) throws Exception {
        Test("C:\\Users\\spinach\\Desktop\\R.txt");
    }

    public static void Test(String path) throws Exception {
        OutputStream outputStream = new FileOutputStream(path);
        OutputStreamWriter outputStreamWrite = new OutputStreamWriter(outputStream,                                                                                                                                                                                                                              StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWrite);
        String str = "欢迎来到Hppaygeniubi小课堂";

        bufferedWriter.write(str);
        bufferedWriter.write(" 学");
        bufferedWriter.write(" 学习");
        bufferedWriter.write(" 学习很多课程");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}


