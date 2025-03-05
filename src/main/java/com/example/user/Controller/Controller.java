package com.example.user.Controller;

import com.example.user.Model.UserM;
import com.example.user.Service.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserS userS;

    @GetMapping("/register")
    public String ShowFroms(Model model) {
        model.addAttribute("user", new UserM());
        return "register";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute UserM user) {
        userS.UserRegister(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String ShowLoginForm(Model model) {
        model.addAttribute("user", new UserM());
        return "login";
    }

    @PostMapping("/login")
    public String Login(@RequestParam UserM user) {
        return "redirect:/user/login";
    }

    @GetMapping("/password-recovery")
    public String PasswordRecovery() {
        return "redirect:/user/login";
    }

    @PostMapping("/password-recovery")
    public String PasswordRecovery(@RequestParam UserM user) {
        return "redirect:/user/confirm-code";
    }

    @GetMapping("/confirm-code")
    public String ConfirmCode() {
        return "redirect:/confirm-code";
    }

    @PostMapping("/confirm-code")
    public String ConfirmCode(@RequestParam UserM user) {
        return "redirect:/user/new-password";
    }

    @GetMapping("/new-password")
    public String NewPassword() {
        return "redirect:/new-password";
    }

    @PostMapping("/new-password")
    public String NewPassword(@RequestParam UUID id, @RequestParam String newpassword) {
        userS.UpdatePassword(id, newpassword);
        return "redirect:/user/login";
    }

    @GetMapping("/find-by-email")
    public String FindByEmail() {
        return "redirect:/find-by-email";
    }

    @PostMapping("/find-by-email")
    public String FindByEmail(@RequestParam String email) {
        userS.findByEmail(email);
        return "redirect:/user/login";
    }
}