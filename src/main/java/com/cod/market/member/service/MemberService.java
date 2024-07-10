package com.cod.market.member.service;

import com.cod.market.member.entity.Member;
import com.cod.market.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member join(String username, String password, String email, String nickname) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setEmail(email);
        member.setNickname(nickname);
        member.setCreateDate(LocalDateTime.now());

        memberRepository.save(member);

        return member;
    }

    public Member findByUsername(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);
        if ( member.isPresent() ) {
            return member.get();
        } else {
            throw new RuntimeException("member not found");
        }
    }
}