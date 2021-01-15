package com.example.flight_reservation.model;

import com.example.flight_reservation.model.entity.Abstract;
import com.example.flight_reservation.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@Entity
public class User extends Abstract {

    private String firstName;
    private String lastName;
    @NotBlank
    @Email
    private String email;
//    @ValidPassword
//    @Size(min=8, max=20)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public User() {
    }
}
