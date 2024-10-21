package com.company.service;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.security.core.userdetails.User.UserBuilder;



@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao")
    private UserRepositoryCustom userRepo;
    @Qualifier("userDao")
    @Autowired
    public void setUserRepo(UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepo.findByPhone(phone);
        if (user == null) {
            throw new UsernameNotFoundException("User not found"+phone);
        }
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(phone);

            builder.disabled(false);
            builder.password(user.getPassword());

            String [] authoritiesArr = new String[] {"USER","ADMIN"};
            builder.authorities(authoritiesArr);

        return builder.build();



    }
}
