package com.venomo.UserService.Controller;

import com.venomo.UserService.Entity.User;
import com.venomo.UserService.Service.UserService;
import com.venomo.UserService.VO.UserDepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser (@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDepartmentVO getUserAndDepartment (@PathVariable("id") Long userId) {
        return userService.getUserAndDepartment(userId);
    }

}
