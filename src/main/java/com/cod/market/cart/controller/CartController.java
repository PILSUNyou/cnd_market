package com.cod.market.cart.controller;

import com.cod.market.cart.entity.CartItem;
import com.cod.market.cart.service.CartService;
import com.cod.market.member.entity.Member;
import com.cod.market.member.service.MemberService;
import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final MemberService memberService;
    private final ProductService productService;

    //장바구니 리스트
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Principal principal, Model model) {
        Member member = memberService.findByUsername(principal.getName());
        List<CartItem> cartList = cartService.getList(member);

        model.addAttribute("cartList", cartList);
        return "cart/list";
    }

    // 추가하기
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, Principal principal) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUsername(principal.getName());

        cartService.add(product, member);

        return "redirect:/cart/list";
    }
}
