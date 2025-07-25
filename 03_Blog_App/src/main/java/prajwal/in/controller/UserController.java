package prajwal.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import prajwal.in.enity.User;
import prajwal.in.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    
   

    // Show Registration Page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle Registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        boolean status = userService.saveUser(user);
        if (status) {
            model.addAttribute("msg", "Registration successful. Please login.");
            return "login";
        } else {
            model.addAttribute("error", "Email already registered.");
            return "register";
        }
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Handle Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String pwd,
                            HttpSession session,
                            Model model) {
        User user = userService.login(email, pwd);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard"; // redirect after login
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
 
    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
