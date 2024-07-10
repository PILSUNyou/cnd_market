package com.cod.market.member.entity;

import com.cod.market.base.BaseEntity;
import com.cod.market.question.entity.Question;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String isActive;

    private List<Question> questionList;
}
