package com.hospital.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(value = "com.hospital.server.dao")
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args){
        SpringApplication.run(ApplicationStart.class,args);
    }

}
