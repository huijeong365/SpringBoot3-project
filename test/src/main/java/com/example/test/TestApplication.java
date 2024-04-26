package com.example.test;

import com.example.test.entity.Test;
import com.example.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args).getBean(TestApplication.class).execute();
	}

	@Autowired
	TestRepository repository;

	private void execute(){
		setup();
	}

	private void setup(){
		Test test1 = new Test(null, "JDK는 JRE와 컴파일러 등의 개발 도구가 포함된다.", true, "오윤석");
		test1 = repository.save(test1);
		System.out.println("등록한 퀴즈는," +test1+ "입니다.");

		Test test2 = new Test(null, "자바 프로그램을 개발하려면 JDK가 반드시 필요하다.", true, "오윤석");
		test2 = repository.save(test2);
		System.out.println("등록한 퀴즈는," +test2+ "입니다.");
	}
}
