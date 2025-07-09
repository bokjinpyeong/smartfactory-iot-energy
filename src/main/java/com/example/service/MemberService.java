// 비즈니스 로직 담당
// 핵심 로직 처리, DB호출, 데이터 가공등 중간 작업

package com.example.service; // 서비스 패키지, 비즈니스 로직 처리 역할

import com.example.domain.Member; // Member 엔티티 import
import com.example.repository.MemberRepository; // MemberRepository import, DB 접근 객체
import lombok.RequiredArgsConstructor; // final 필드 자동 생성자 주입 (Lombok)
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 비밀번호 암호화 라이브러리 import
import org.springframework.stereotype.Service; // 서비스 계층임을 명시

@Service // 서비스 계층 빈 등록
@RequiredArgsConstructor // final 필드 생성자 자동 생성
public class MemberService { // 회원 관련 비즈니스 로직 처리 클래스 시작

    private final MemberRepository memberRepository; // DB 접근을 위한 Repository 주입
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화를 위한 Encoder 생성

    public void register(Member member) { // 회원가입 처리 메서드
        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화 후 설정
        memberRepository.save(member); // DB에 회원 정보 저장
    }

    public boolean authenticate(String email, String rawPassword) { // 로그인 인증 메서드
        return memberRepository.findByEmail(email) // 이메일로 회원 조회
                .map(m -> passwordEncoder.matches(rawPassword, m.getPassword())) // 비밀번호 비교 후 결과 반환
                .orElse(false); // 회원 없을 경우 false 반환
    }

    public boolean existsByEmail(String email) { // 이메일 중복 확인 메서드
        return memberRepository.findByEmail(email).isPresent(); // 존재 여부 반환
    }
}