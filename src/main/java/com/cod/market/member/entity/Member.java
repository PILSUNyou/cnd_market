package com.cod.market.member.entity;

import com.cod.market.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    private String username;

    private String password;

    private String nickname;

    private String email;

}
