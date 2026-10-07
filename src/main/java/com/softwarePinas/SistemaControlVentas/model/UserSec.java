package com.softwarePinas.SistemaControlVentas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")//tablas en bd va en plural
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSec {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)//establece que el atributo no se puede repetir en la tabla.
    private String username;
    private String password;
    //campos necesarios para spring security
    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialNotExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //el eager me va  a cargar todos los roles
    @JoinTable (name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),//nombre de la tabla intermediaria, user_id & role_id son el nombre de las columnas
            inverseJoinColumns=@JoinColumn(name = "role_id"))
    private Set<Role> rolesList = new HashSet<>();

}
