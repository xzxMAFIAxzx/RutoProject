package com.company;



import com.company.dao.impl.UserRepository;

import com.company.entity.User;

import com.company.service.inter.UserServiceInter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication

@EnableCaching
public class RutoDbAppJpaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RutoDbAppJpaSpringApplication.class, args);
    }

    @Autowired
    private UserRepository repo;
    @Autowired
    private UserServiceInter userSer;


    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
//              List<User> list =userSer.getAll(null,null,null,null,null,null,null,null,null);
//               System.out.println(list);
            }
        };
        return clr;
    }

}
