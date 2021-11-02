package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TryCatchTest {
    public static void main(String[] args) {

        // 最后定义的最先关闭
        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\spinach\\Desktop\\草稿.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\spinach\\Desktop\\草稿(copy).txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            int size;
            byte[] buf = new byte[bufferedInputStream.available()];
            while ((size = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
