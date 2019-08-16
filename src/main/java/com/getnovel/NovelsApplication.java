package com.getnovel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.getnovel.*.dao")//指定要扫描的Mapper类的包的路径,
@SpringBootApplication
public class NovelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovelsApplication.class, args);
	}
}
