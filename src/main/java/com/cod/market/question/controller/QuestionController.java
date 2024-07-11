package com.cod.market.question.controller;

import com.cod.market.member.entity.Member;
import com.cod.market.member.service.MemberService;
import com.cod.market.product.entity.Product;
import com.cod.market.product.service.ProductService;
import com.cod.market.question.entity.Question;
import com.cod.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final ProductService productService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()") // 로그인이 확인 된 경우 사용가능 ( isAuthenticated() )
    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id,
                         Principal principal,
                         @RequestParam("content") String content) {

        Product product = productService.getProduct(id);
        Member member = memberService.findByUsername(principal.getName());

        questionService.create(product, member, content);

        return String.format("redirect:/product/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model, Principal principal) {
        Question question = questionService.getQuestion(id);

        if( !question.getMember().getUsername().equals(principal.getName()) ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한 없음");
        }
        // if문에 있는 부분은 submit 한 사용자랑 다를 경우 에러를 발생하게 한다.

        model.addAttribute("question", question);
        return "question/modify";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id,
                         Principal principal,
                         @RequestParam("content") String content) {
        Question question = questionService.getQuestion(id);
        questionService.modify(question, content);

        long productId = question.getProduct().getId(); // product id 불러오기

        return String.format("redirect:/product/detail/%s", productId);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Question question = questionService.getQuestion(id);

        if( !question.getMember().getUsername().equals(principal.getName()) ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한 없음");
        }

        questionService.delete(question);
        long productId = question.getProduct().getId(); // product id 불러오기

        return String.format("redirect:/product/detail/%s", productId);
    }
}
