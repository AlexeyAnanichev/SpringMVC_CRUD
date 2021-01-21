package ru.ananichev.crud.web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ananichev.crud.service.UserService;
import ru.ananichev.crud.model.User;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        if (userService.getAllUsers().isEmpty()) return "emptyUserList";
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "users";
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) return "update";
        userService.updateUser(user, id);
        return "redirect:/users";
    }
}
