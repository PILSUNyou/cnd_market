package com.cod.market.product.entity;

import com.cod.market.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;

    private int price;

}
