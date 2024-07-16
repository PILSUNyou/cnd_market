package com.cod.market.member.entity;

import com.cod.market.base.entity.BaseEntity;
import com.cod.market.cart.entity.Cart;
import com.cod.market.product.entity.Product;
import com.cod.market.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
public class Member extends BaseEntity {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String isActive;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Cart> cartList;
}
