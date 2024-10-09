package com.company;


import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.UserRepository;
import com.company.dao.impl.UserRepositoryCustomImpl;
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


@SpringBootApplication(scanBasePackages = {"com.company","com.company"})
@EnableCaching
public class RutoDbAppJpaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RutoDbAppJpaSpringApplication.class, args);
    }


    @Autowired
    private UserServiceInter userService;
    @Autowired
    private UserRepository repo;
    @Autowired
    private UserRepositoryCustomImpl customRepo;




    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
//                List<User> users = userService.getUserSimple(null,null,null,null,null,null);
//                for (User user : users) {
//                    System.out.println(user);
//                }


                System.out.println(customRepo.findByPhone("+994518238008"));


            }
        };
        return clr;
    }

}
