package com.cod.market.answer.entity;


import com.cod.market.base.entity.BaseEntity;
import com.cod.market.member.entity.Member;
import com.cod.market.question.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
public class Answer extends BaseEntity {

    private String comment;

    @OneToOne
    private Member member;

    @OneToOne
    private Question question;
}
