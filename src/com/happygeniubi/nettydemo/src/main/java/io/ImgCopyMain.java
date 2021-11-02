package io;

import java.io.*;

// 图片拷贝测试类
public class ImgCopyMain {

    public static void main(String[] args) {
        String dir = "C:\\Users\\spinach\\Desktop";
        File file = new File(dir+"\\img1");
        File[] files = file.listFiles();
        if(files != null && files.length > 0) {
            for (File from : files) {
                String fileName = from.getName();
                copy(from.getAbsolutePath(), dir + "\\img2\\" + fileName);
            }
        }else {
            System.out.println("无法找到文件源!");
        }
    }

    public static void copy(String from, String to) {
        System.out.println(" from:" + from + " to:" + to);
        try {
            System.out.println(new File(to).getParent());
            File targetDir = new File(new File(to).getParent());
            if(!targetDir.exists()) {
                targetDir.mkdir();
            }
            FileInputStream fileInputStream = new FileInputStream(from);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(to);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int size;
            byte[] buf = new byte[bufferedInputStream.available()];
            while ((size = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(buf, 0, size);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
