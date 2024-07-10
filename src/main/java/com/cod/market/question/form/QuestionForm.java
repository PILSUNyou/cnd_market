package com.cod.market.question.form;

import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class QuestionForm {
    @Size(min = 1, max = 10000)
    @NotBlank
    private String content;

    @NotBlank
    private Member member;

    @NotBlank
    private Product product;

}
