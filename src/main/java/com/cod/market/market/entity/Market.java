package com.cod.market.market.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.product.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
public class Market extends BaseEntity {

    private String email;

    private String name;

    private String info;

    @OneToOne
    private Member member;

    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE)
    private List<Product> productList;
}
