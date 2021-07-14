package top.lqh;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

class ProductDataServiceApplicationTest {

    @Test
    void getPort(){
        int port = 8001;
        Socket skt = new Socket();
        SocketAddress address = new InetSocketAddress(port);
        try {
            skt.connect(address, 2000);
            System.out.println("端口占用" + port);
            port++;
            getPort();
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("端口正常" + port);
        }
    }

}
