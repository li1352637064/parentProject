package top.lqh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @date: 2021-07-13 16:39
 */
@FeignClient("PRODUCT-DATA-SERVICE")
public interface ProductClient {
    @GetMapping("list")
    List<Product> list();
}
