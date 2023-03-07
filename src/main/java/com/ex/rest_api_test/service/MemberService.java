package com.ex.rest_api_test.service;

import com.ex.rest_api_test.entity.Member;
import com.ex.rest_api_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(String name, int age){
        Member member = Member.builder()
                .name(name)
                .age(age)
                .build();

        memberRepository.save(member);

        return member;
    }
}
