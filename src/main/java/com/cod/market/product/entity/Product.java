package com.cod.market.product.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.market.entity.Market;
import com.cod.market.question.entity.Question;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;

    private String description;

    private String isActive;

    private int price;

    private int hitCount;

    private Market market;

    private List<Question> questionList;
}
