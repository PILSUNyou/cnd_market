package com.cod.market.oder.entity;

import com.cod.market.base.entity.BaseEntity;
import com.cod.market.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_order")
public class Order extends BaseEntity {

    @ManyToOne(fetch = LAZY)
    private Member buyer;

    private String name;

    private boolean isPaid; // 구매 했는지 확인

    private boolean isCanceled; // 취소 했는지 확인

    private boolean isRefunded;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<OrderItem> orderItemList;
}
