package com.cod.market.question.service;

import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import com.cod.market.question.entity.Question;
import com.cod.market.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;


    public void create(Product product, Member member, String content) {
        Question question = new Question();
        question.setProduct(product);
        question.setMember(member);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());

        questionRepository.save(question);
    }
}