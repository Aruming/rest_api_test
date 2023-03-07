package com.ex.rest_api_test.controller;

import com.ex.rest_api_test.entity.Member;
import com.ex.rest_api_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("")
    public ResponseEntity list(){
        List<Member> memberList = memberService.findAll();

        return new ResponseEntity<>(memberList, null, HttpStatus.OK);
    }
}
