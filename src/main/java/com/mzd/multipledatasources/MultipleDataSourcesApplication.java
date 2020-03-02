package com.mzd.multipledatasources;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
@SpringBootApplication
//启动消息队列
@EnableJms
//指定mapper的xml文件路径
@MapperScan("com.mzd.multipledatasources.mapper")
public class MultipleDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourcesApplication.class, args);
	}
}
