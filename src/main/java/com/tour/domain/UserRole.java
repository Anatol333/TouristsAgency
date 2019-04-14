package com.tour.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    private Integer user_id;

    private String roles;

    public UserRole() {
    }

    public UserRole(Integer user_id, String roles) {
        this.user_id = user_id;
        this.roles = roles;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}