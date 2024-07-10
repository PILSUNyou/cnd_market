package com.cod.market.question.controller;

import com.cod.market.member.entity.Member;
import com.cod.market.member.service.MemberService;
import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import com.cod.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final ProductService productService;
    private final MemberService memberService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id,
                         Principal principal,
                         @RequestParam("content") String content) {

        Product product = productService.getProduct(id);
        Member member = memberService.findByUsername(principal.getName());

        questionService.create(product, member, content);

        return String.format("redirect:/product/detail/%s",id);
    }
}
