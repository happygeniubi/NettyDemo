package bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class BioServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        System.out.println("BioServer启动...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("server is start in port:" + PORT);
            Socket socket = null;
            while (true) {
                // 阻塞,等待Socket链接
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
                // 线程池
//                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null) {
                serverSocket.close();
                System.out.println("server is close");
            }
        }
    }
}

