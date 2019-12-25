package cn.ting.worktable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.ting.worktable.mapper")
public class WorktableApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorktableApplication.class, args);
	}

}
