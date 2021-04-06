package com.venomo.UserService.Service;

import com.venomo.UserService.Entity.User;
import com.venomo.UserService.Repository.UserRepository;
import com.venomo.UserService.VO.Department;
import com.venomo.UserService.VO.UserDepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserDepartmentVO getUserAndDepartment(Long userId) {
        UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
        User user = userRepository.findById(userId).orElse(null);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        userDepartmentVO.setUser(user);
        userDepartmentVO.setDepartment(department);
        return userDepartmentVO;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
