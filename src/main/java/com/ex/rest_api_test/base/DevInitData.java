package com.ex.rest_api_test.base;

import com.ex.rest_api_test.entity.Member;
import com.ex.rest_api_test.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevInitData {
    @Bean
    CommandLineRunner initData(MemberService memberService){
        return  args -> {
            Member member1 = memberService.join("정대만", 19);
            Member member2 = memberService.join("송태섭", 18);
        };
    }
}
