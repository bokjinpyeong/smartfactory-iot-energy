// 데이터 베이스 접근 담당
// DB 저장, 조회, 수정, 삭제 담당
// JpaRepository 상속으로 기본 CRUD 자동 제공

package com.example.repository; // Repository 패키지, DB 접근 계층

import com.example.domain.Member; // Member 엔티티 import
import org.springframework.data.jpa.repository.JpaRepository; // JPA 기본 Repository import

import java.util.Optional; // Optional 반환을 위한 import

public interface MemberRepository extends JpaRepository<Member, Long> { // Member 엔티티 DB 접근 인터페이스 정의

    Optional<Member> findByEmail(String email); // 이메일로 회원 조회 메서드, 중복 체크 및 로그인 검증에 사용
}

// 인터페이스 선언 (클래스 아님, 구현체는 Spring이 자동 생성) 이름은 MemberRepository, 즉 "회원 관련 DB 작업을 담당하는 객체"
// JpaRepository를 상속하여 DB 작업 기능을 자동으로 제공