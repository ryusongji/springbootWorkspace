package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 기존 mapper 어노테이션은 interface가 들고있었음
// Mapper의 구성요소 중 Interface를 대상
@MapperScan(basePackages = "com.yedam.app.**.mapper")
public class Sp04Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp04Application.class, args);
	}

}
