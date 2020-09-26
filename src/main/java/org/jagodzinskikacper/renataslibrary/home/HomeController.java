package org.jagodzinskikacper.renataslibrary.home;

import org.jagodzinskikacper.renataslibrary.user.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal CurrentUser customUser,Model model){
        if(customUser != null){
            model.addAttribute(customUser);
        }
        return "home";}

    @GetMapping("/about")
    @ResponseBody
    public String about(){return "Here you can find some details for logged users";}
}
