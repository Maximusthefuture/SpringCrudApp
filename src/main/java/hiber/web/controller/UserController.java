package hiber.web.controller;


import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String hello(ModelMap model) {
        String hello = "hello";

        return "hello";
    }

    @GetMapping("/users")
    public String getUser(ModelMap model) {
        userService.add(new User("fdsfsdf", "fsdfdsf", (byte) 8));
        userService.add(new User("fdsfsdf", "fsdfdsf", (byte) 8));
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @PostMapping("/user")
    public String addUser(ModelMap model) {
        userService.add(new User("fdsfsdf", "fsdfdsf", (byte) 8));
        return "redirect:/users";
    }
}
