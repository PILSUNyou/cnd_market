package com.cod.market.product.controller;

import com.cod.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm/product")
public class AdmProductController {
    private final ProductService productService;

    @GetMapping("/create")
    public String create() {
        return "adm/product/create";
    }
}
