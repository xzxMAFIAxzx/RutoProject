package com.company.controller;



import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserServiceInter userService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("user") UserForm u) {
        List<User> list =userService.getAll(u.getName(), u.getSurname(), u.getPhone(), u.getEmail(), u.getAdress(), u.getProfileDesc(), u.getNationalityId(), u.getBirthplace(), u.getBirthDate());

        ModelAndView mav = new ModelAndView("users");

        mav.addObject("users", list);

        return mav;
    }


    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm(null,null,null,null,null,null,null,null,null,null);
    }
}
