// 프로젝트 실행 시작점, 전체 프로젝트 구동
// main 함수에서 스프링 부트 앱 시작함
package com.example;

import org.springframework.boot.SpringApplication; // 스프링 부트를 실행하는 핵심 클래스 SpringApplication을 가져옴, 실제로 어플을 시작하는 역할
import org.springframework.boot.autoconfigure.SpringBootApplication; // @SpringBootApplication 어노테이션을 사용하기 위해 import

@SpringBootApplication  // 스프링 부트 자동 설정, 컴포넌트 스캔, 스프링 부트의 시작 클래스
public class DemoApplication {

    public static void main(String[] args) { // 자바 애플리케이션의 진입점 메서드입니다. 자바 프로그램 실행 시 가장 먼저 호출되는 메서드

        SpringApplication.run(DemoApplication.class, args);  // 내부적으로 내장 톰캣 서버가 구동되고, 프로젝트 전체가 실행됨
    }
}
