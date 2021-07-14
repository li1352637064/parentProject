package top.lqh.service;

import org.springframework.stereotype.Service;
import top.lqh.feignClient.ProductClient;
import top.lqh.pojo.Product;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date: 2021-07-13 16:40
 */
@Service
public class ProductService {
    @Resource
    private ProductClient productClient;

    public List<Product> list(){
        return productClient.list();
    }
}
