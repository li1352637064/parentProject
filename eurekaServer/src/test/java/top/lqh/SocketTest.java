package top.lqh;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @date: 2021-07-13 17:02
 */
public class SocketTest {
    @Test
    void SocketT(){
        //总端口数量
        int port = 65535;
        //每条线程处理的端口号数量
        int handleNumber = 65535 / 500;
        int threadNumber = port / handleNumber;

        //线程数量
        for (int i = 0; i < threadNumber + 1; i++) {
            //线程
            int finalI = i;
            new Thread(() -> {
                //每条线程处理自己范围内的端口
                int begin = finalI * handleNumber;
                int end = (finalI + 1) * handleNumber;

                for (int j = begin; j < end; j++) {
                    if (j >= port) {
                        break;
                    }
                    verify(j);
                }

            }).start();
        }

    }

    /**
     * 验证端口
     * @param port
     */
    private static void verify(int port){
        new Thread(() -> {
            SocketAddress a = new InetSocketAddress(port);

            Socket skt = new Socket();

            try {
                skt.connect(a, 1000);
                System.out.printf("%s端口被占用%n",port);
            } catch (IOException e) {
                //System.out.println(e.getMessage());
            }
        }).start();
    }
}
