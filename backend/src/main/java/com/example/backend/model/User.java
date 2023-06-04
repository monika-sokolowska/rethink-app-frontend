package com.example.backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_user", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;
    @Column(name = "last_name", columnDefinition = "VARCHAR(45)")
    private String lastName;
    @Column(name = "email", columnDefinition = "VARCHAR(45)")
    private String email;
    @Column(name = "password", columnDefinition = "VARCHAR(64)")
    private String password;
    @Column(name = "main_goal", columnDefinition = "FLOAT(4,2)")
    private Float mainGoal;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mainGoal = 5.0f;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getMainGoal() {
        return mainGoal;
    }

    public void setMainGoal(Float mainGoal) {
        this.mainGoal = mainGoal;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
