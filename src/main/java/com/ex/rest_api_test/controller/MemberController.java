package com.ex.rest_api_test.controller;

import com.ex.rest_api_test.dto.MemberJoinDto;
import com.ex.rest_api_test.dto.MemberModifyDto;
import com.ex.rest_api_test.entity.Member;
import com.ex.rest_api_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("")
    public ResponseEntity list(){
        List<Member> memberList = memberService.findAll();

        return new ResponseEntity(memberList, null, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity detail(@PathVariable Long id){
        Member member = memberService.findById(id).orElse(null);

        if(member == null){
            return new ResponseEntity("존재하지 않는 회원입니다.", null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(member, null, HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody MemberJoinDto memberJoinDto){
        Member newMember = memberService.join(memberJoinDto.getName(), memberJoinDto.getAge());

        return new ResponseEntity(newMember, null, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Member member = memberService.findById(id).orElse(null);

        if(member == null){
            return new ResponseEntity("존재하지 않는 회원입니다.", null, HttpStatus.BAD_REQUEST);
        }

        memberService.delete(member);

        return new ResponseEntity(member.getId()+"번 회원 삭제 완료", null, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody MemberModifyDto memberModifyDto){
        Member member = memberService.findById(id).orElse(null);

        if(member == null){
            return new ResponseEntity("존재하지 않는 회원입니다.", null, HttpStatus.BAD_REQUEST);
        }

        memberService.update(member, memberModifyDto);

        return new ResponseEntity(member, null, HttpStatus.OK);
    }
}
