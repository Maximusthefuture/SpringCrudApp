package hiber.web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String hello(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/signup")
    public String showSingInForm(User user) {
        return "add_user";
    }

    @RequestMapping(value = "/adduser")
    public String createUser(@Validated User user, BindingResult result, ModelMap model) {
        userService.add(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit")
    public String showUpdateForm(@RequestParam long id, ModelMap modelMap) {
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "update";
    }

    @RequestMapping(value = "/update")
    public String updateUser(@RequestParam long id, User user) {
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/";
    }


}
