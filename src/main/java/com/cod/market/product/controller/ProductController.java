package com.cod.market.product.controller;

import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "kw", defaultValue = "" )String kw) {
        Page<Product> paging = productService.getList(page, kw);
//       List를 Page로 변경하여 Pagination 적용하기.
//       kw를 사용하여 검색기능 활성화 하기 sevice, repository 참조
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);

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
