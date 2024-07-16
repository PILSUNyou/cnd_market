package com.cod.market.base.initData;

import com.cod.market.member.service.MemberService;
import com.cod.market.product.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevInitData implements BeforeInitData{
    @Bean
    CommandLineRunner initData(MemberService memberService, ProductService productService) {
        return args -> {
            beforeInit();

            // membe init
            String password = "1234";
            memberService.join("user1", password, "user1@test.com", "user1");
            memberService.join("user2", password, "user2@test.com", "user2");
            memberService.join("user3", password, "user3@test.com", "user3");
            memberService.join("user4", password, "user4@test.com", "user4");

            // product init
            productService.create("타이틀1", "1 설명 입니다.", 10000);
            productService.create("타이틀2", "2 설명 입니다.", 20000);
            productService.create("타이틀3", "3 설명 입니다.", 30000);
            productService.create("타이틀4", "4 설명 입니다.", 40000);

        };
    }
}
