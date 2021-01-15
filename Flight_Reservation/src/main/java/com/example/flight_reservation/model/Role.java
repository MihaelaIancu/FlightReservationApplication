package com.example.flight_reservation.model;
import com.example.flight_reservation.model.entity.Abstract;
import org.springframework.security.core.GrantedAuthority;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@Entity
public class Role extends Abstract implements GrantedAuthority{

    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }

}
