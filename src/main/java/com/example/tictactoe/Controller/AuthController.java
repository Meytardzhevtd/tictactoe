package com.example.tictactoe.Controller;

import com.example.tictactoe.model.Player;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api")
public class AuthController {
    private final ConcurrentHashMap<Long, Player> users = new ConcurrentHashMap<>();
    private final AtomicLong userIdGenerator = new AtomicLong(1);

    @PostMapping("/register")
    public String registPlayer(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        System.out.println(
                "Пользователь зарегистрирован. Name = " + name + " Email = " + email + " Password = " + password);

        return "redirect:/login.html";
    }

    // @PostMapping("/passwordVerificatin")
    // public String changePassword(@RequestParam Long userId, @RequestParam String
    // oldPassword,
    // @RequestParam String newPassword) {
    // Player player = users.get(userId);
    // if (player == null) {
    // return "redirect:/changepassword.html?error=invalid_user";
    // }
    // }

}
