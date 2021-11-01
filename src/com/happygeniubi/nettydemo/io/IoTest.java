package com.happygeniubi.nettydemo.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IoTest {
    public static void main(String[] args) {
        InputStream inputStream =new InputStream() {
            @Override

            public int read() throws IOException {
                return 0;
            }
        };
    }
}
