package com.cod.market.product.controller;

import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productService.getList();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProduct(id);

        model.addAttribute("product", product);
        System.out.println(product.toString());

        return "product/detail";
    }
}
