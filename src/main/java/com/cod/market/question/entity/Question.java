package com.cod.market.question.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question extends BaseEntity {

    private String subject;

    private String content;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;
}
