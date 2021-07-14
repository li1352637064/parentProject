package top.lqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lqh.service.ProductService;

import javax.annotation.Resource;

/**
 * @date: 2021-07-13 16:41
 */
@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("list", productService.list());
        return "products";
    }
}
