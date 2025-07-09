package com.example.controller; // 컨트롤러 패키지, 요청을 받아 처리하는 역할

import com.example.domain.Member; // Member 도메인 클래스 import, 회원 정보 구조 정의
import com.example.service.MemberService; // MemberService 서비스 클래스 import, 비즈니스 로직 처리
import lombok.RequiredArgsConstructor; // final 필드 자동 생성자 주입 (Lombok 사용)
import org.springframework.web.bind.annotation.*; // REST API 관련 어노테이션 import

@RestController // REST API를 처리하는 컨트롤러, JSON으로 자동 변환해 응답
@RequiredArgsConstructor // final 필드에 대해 생성자 자동 생성, 의존성 주입 간편화
@RequestMapping("/auth") // 기본 URL 경로 설정, http://localhost:8080/auth 기준으로 요청 처리
public class AuthController { // 인증 관련 API 컨트롤러 클래스 시작

    private final MemberService memberService; // MemberService를 사용하기 위한 필드 선언

    @PostMapping("/signup") // 회원가입 요청 처리, POST 방식, 경로: /auth/signup
    public String signup(@RequestBody Member member) { // 요청 본문(JSON)을 Member 객체로 변환
        if (memberService.existsByEmail(member.getEmail())) { // 이메일 중복 여부 확인
            return "이미 가입된 이메일입니다."; // 중복일 경우 실패 메시지 반환
        }
        memberService.register(member); // 회원가입 로직 실행, 비밀번호 암호화 후 저장
        return "회원가입 성공"; // 성공 메시지 반환
    }

    @PostMapping("/login") // 로그인 요청 처리, POST 방식, 경로: /auth/login
    public String login(@RequestBody Member member) { // 요청 본문(JSON)을 Member 객체로 변환
        boolean success = memberService.authenticate(member.getEmail(), member.getPassword()); // 이메일, 비밀번호로 로그인 검증
        return success ? "로그인 성공" : "이메일 또는 비밀번호가 틀립니다."; // 성공 여부에 따라 결과 반환
    }
}