package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 缓冲流测试类.
public class BufferMain {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\spinach\\Desktop\\happygeniubi.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\spinach\\Desktop\\happygeniubi(copy).txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            int size;
            byte [] buf = new byte[fileInputStream.available()];

            while((size = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0 ,size);
            }
            // 刷新此缓冲区的输出流才可以保证数据全部输出完成.(在调用.close关闭流的时候会自动刷新)
//            bufferedOutputStream.flush();
//            bufferedInputStream.close();
//            bufferedOutputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
