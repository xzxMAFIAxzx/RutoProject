package com.company.controller;


import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public ModelAndView index(
            @Valid
            @ModelAttribute("user") UserForm u,
            BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if(bindingResult.hasErrors()) {
            return mv;
        }
        List<User> list =userService.getAll(u.getName(), u.getSurname(), u.getPhone(), u.getEmail(), u.getAdress(), u.getProfileDesc(), u.getNationality(), u.getBirthplace(), u.getBirthDate());
        mv.addObject("users", list);

        return mv;
    }

//     @RequestMapping(method = RequestMethod.GET)
//     public ModelAndView index2(@RequestParam(value = "name", required = false) String name,
//                                @RequestParam(value = "surname", required = false) String surname,
//                                @RequestParam(value = "nid", required = false) Integer nationality){
//        List<User> list = userService.getUserSimple(name,surname,null,null,null,nationality );
//        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("users", list);
//        return mv;
//     }


    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm(null, null, null, null, null, null, null, null, null, null);
    }
}
