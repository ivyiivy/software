package com.HIT.software;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;


@Controller
public class UserController {

    private UserRepository userRepository;

    private static final String isAdmin = "0";

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/index")
    public String signIn() {
        return "index";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }




    @PostMapping("/signup")
    public String signUP(User user,Map<String,Object> map) {
        User user1=userRepository.findByEmail(user.getEmail());
        if (user1!=null){
            map.put("msg","此邮箱已注册");
            return "signup";
        }
        user.setIsAdmin(isAdmin);
        userRepository.save(user);
        return "redirect:/index";
    }


    @PostMapping("/index")
    public String signIn(User user, Map<String,Object> map) {

        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1 == null) {
            map.put("msg","没有此用户");
            return "index";
        }
        if (!user1.getPassword().equals(user.getPassword())) {
            map.put("msg","密码错误");
            return "index";
        }

        return "redirect:/hello";


    }


}
