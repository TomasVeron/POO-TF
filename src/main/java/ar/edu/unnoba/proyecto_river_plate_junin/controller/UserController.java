package ar.edu.unnoba.proyecto_river_plate_junin.controller;


import ar.edu.unnoba.proyecto_river_plate_junin.service.*;
import ar.edu.unnoba.proyecto_river_plate_junin.model.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginUser(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            model.addAttribute("user", user);
            return"/register";
        }
        try{
            userService.createUser(user);
        }catch(Exception e){
            model.addAttribute("formError", e.getMessage());
            model.addAttribute("user", user);
            return "/register";
        }

        return "redirect:/";
    }

    @GetMapping("/users")
    public String usersList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "/users/users";

    }

    @GetMapping("/users/view/{id}")
    public String usersView(@PathVariable("id") Long userId,Model model){
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "users/view";
    }

    @GetMapping("/users/delete/{id}")
    public String usersDelete(@PathVariable("id") Long userId,  Authentication authentication, RedirectAttributes redirectAttributes){
        User user = userService.getUserById(userId);
        User sessionUser = (User)authentication.getPrincipal();
        try {
            userService.deleteUser(user,sessionUser);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("userDeleteError", e.getMessage());
        }
        return "redirect:/users";
    }


}
