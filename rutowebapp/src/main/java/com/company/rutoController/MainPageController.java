package com.company.rutoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @GetMapping("/mainpage") // Root URL-i idarə edir
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("redirect:/users"); // /users səhifəsinə yönləndirir
        return mav;
    }
}
