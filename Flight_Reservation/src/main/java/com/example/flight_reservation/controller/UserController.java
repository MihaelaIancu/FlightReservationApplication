package com.example.flight_reservation.controller;

import com.example.flight_reservation.model.User;
import com.example.flight_reservation.repository.UserRepository;
import com.example.flight_reservation.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityService securityService;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, SecurityService securityService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.securityService = securityService;
    }

    @RequestMapping("/registerUser")
    public String showRegistration(){
        return "login/registerUser";
    }

    @RequestMapping("/loginUser")
    public String showLogin(){
        return "login/login";
    }

    @RequestMapping("register-user")
    public String register(@ModelAttribute User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";
    }

    @PostMapping("login-user")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        Boolean userExist = securityService.login(email,password);
        if(userExist){
            return "findFlights";
        }
        else{
            modelMap.addAttribute("msg","Invalid credentials");
        }
        return "login/login";
    }


}
