package com.example.tictactoe.Controller;

import com.example.tictactoe.model.Player;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/api")
public class AuthController {
    private final ConcurrentHashMap<Long, Player> users = new ConcurrentHashMap<>();
    private final AtomicLong userIdGenerator = new AtomicLong(1);

    @PostMapping("/register")
    public String registPlayer(@RequestParam String name, @RequestParam String email) {
        Long userId = userIdGenerator.getAndIncrement();
        Player player = new Player(userId, name, email);
        users.put(userId, player);
        System.out.println("User registred: " + player);
        return "redirect:/profile.html";
    }

}
