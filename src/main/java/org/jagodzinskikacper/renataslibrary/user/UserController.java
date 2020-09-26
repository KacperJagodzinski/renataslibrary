package org.jagodzinskikacper.renataslibrary.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, @RequestParam String password2){
        if(result.hasErrors()){
            return "register";
        }
        User existingUser = userService.findByUserName(user.getUsername());
        if(existingUser!=null){
            result.addError(new FieldError("user","username","This username is taken"));
            return "register";
        }
        if(!user.getPassword().equals(password2)){
            result.addError(new FieldError("user","password","Passwords do not match"));
            return "register";
        }
        user.setPassword(user.getPassword());
        userService.saveUser(user);
        return "redirect:login";
    }
    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }
}
