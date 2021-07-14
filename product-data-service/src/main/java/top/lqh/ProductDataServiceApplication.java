package top.lqh;

import brave.sampler.Sampler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @date: 2021-07-14 09:43
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {
    private static int port = 8001;

    public static void main(String[] args) {
        getPort();
        SpringApplicationBuilder app = new SpringApplicationBuilder(ProductDataServiceApplication.class);
        app.properties("server.port=" + port);
        app.run(args);
    }

    /**
     * 设置端口
     */
    private static void getPort(){
        Socket skt = new Socket();
        SocketAddress address = new InetSocketAddress(port);
        try {
            skt.connect(address, 1000);
            port++;
            getPort();
        } catch (IOException e) {
            return;
        }
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
