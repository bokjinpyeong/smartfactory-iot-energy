// 데이터 모델 (DB 테이블 매핑)
// DB 테이블과 Java 클래스 연결
// 필드 = DB 칼럼
package com.example.domain; // 도메인 패키지, DB 테이블과 매핑되는 클래스

import jakarta.persistence.*; // JPA 엔티티 매핑 관련 어노테이션 import
import lombok.Getter; // Lombok의 Getter 자동 생성
import lombok.Setter; // Lombok의 Setter 자동 생성

@Entity // JPA 엔티티로 DB 테이블과 매핑됨을 명시
@Getter // Getter 메서드 자동 생성
@Setter // Setter 메서드 자동 생성
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member { // 회원 정보를 담는 Member 엔티티 정의

    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    private Long id; // 회원 고유 ID

    private String company; // 회사명
    private String name; // 회원 이름

    @Column(unique = true) // 이메일 중복 방지 설정
    private String email; // 회원 이메일
    private String phone;   // 전화번호
    private String password; // 비밀번호 (암호화되어 저장)
}

// JPA: SQL을 직접 일일이 안 써도, 자바 코드로 DB 저장, 조회, 삭제를 쉽게 하는 기술
// 자바 객체와 데이터베이스를 자동으로 연결(매핑)해줌 / 자바 코드를 sql로 자동 변환한다고 생각하면 됨

// 어노테이션: 자바 코드에 @로 시작하는 메타정보를 추가하는 기능 / 컴파일러나 프레임워크가 특정 동작하도록 지시 / 라이브러리라고 생각하면 됨