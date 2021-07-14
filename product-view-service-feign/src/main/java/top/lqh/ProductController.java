package top.lqh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @date: 2021-07-13 16:41
 */
@Controller
public class ProductController {
    @Resource
    private ProductClient productClient;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("list", productClient.list());
        return "products";
    }
}
