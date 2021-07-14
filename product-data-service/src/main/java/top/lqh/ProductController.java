package top.lqh;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2021-07-14 10:06
 */
@RestController
public class ProductController {
    @Value("${server.port}")
    String port;

    /**
     * 返回数据
     * @return
     */
    @GetMapping
    public List<Product> list(){
        String template = "{} - {} - {}";
        List<Product> list = new ArrayList<>();
        list.add(new Product(randomInt(10), StrUtil.format(template, randomStr(6), new DateTime(), port), randomInt(100)));
        list.add(new Product(randomInt(10), StrUtil.format(template, randomStr(6), new DateTime(), port), randomInt(100)));
        list.add(new Product(randomInt(10), StrUtil.format(template, randomStr(6), new DateTime(), port), randomInt(100)));
        list.add(new Product(randomInt(10), StrUtil.format(template, randomStr(6), new DateTime(), port), randomInt(100)));
        list.add(new Product(randomInt(10), StrUtil.format(template, randomStr(6), new DateTime(), port), randomInt(100)));
        return list;
    }

    /**
     * 随机生成 0~max之间的数值
     *
     * @param max
     * @return
     */
    private int randomInt(int max){
        return RandomUtil.randomInt(0, max);
    }

    /**
     * 生成指定长度的随机字符串
     * @param length
     * @return
     */
    private String randomStr(int length){
        return RandomUtil.randomString(length);
    }
}
