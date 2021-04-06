package com.venomo.UserService.VO;

import com.venomo.UserService.Entity.User;

public class UserDepartmentVO {

    private User user;
    private Department department;

    public UserDepartmentVO(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public UserDepartmentVO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
