package com.baizhi;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* 扫描dao全部接口 */
@MapperScan("com.baizhi.dao")
public class EmsThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsThymeleafApplication.class, args);
    }

}
