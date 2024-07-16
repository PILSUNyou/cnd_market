package com.cod.market.product.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.cart.entity.Cart;
import com.cod.market.member.entity.Member;
import com.cod.market.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private String name;

    private String description;

    private String isActive;

    private int price;

    private int hitCount;

    private String thumbnailImg;

    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Cart> cartList;
}
