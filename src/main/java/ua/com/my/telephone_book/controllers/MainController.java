package ua.com.my.telephone_book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.com.my.telephone_book.models.User;
import ua.com.my.telephone_book.repository.SkillRepo;
import ua.com.my.telephone_book.repository.UserRepo;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillRepo skillRepo;

    @GetMapping("/users")
    public List<User> index () {
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public List<User> saveUser(@RequestBody User user) {
        userRepo.save(user);
        user.getSkill().forEach(skill -> {
            skill.setUser(user);
            skillRepo.save(skill);
        });

        return userRepo.findAll();
    }
}
