package com.cod.market.cash.entity;


import com.cod.market.base.entity.BaseEntity;
import com.cod.market.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CashLog extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member member;

    private Long price;

}
