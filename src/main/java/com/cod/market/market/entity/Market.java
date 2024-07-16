package com.cod.market.market.entity;

import com.cod.market.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
public class Market extends BaseEntity {

    private String email;

    private String name;

    private String info;

}
