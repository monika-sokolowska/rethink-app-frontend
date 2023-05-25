package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
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
    @Column(name = "main_goal", columnDefinition = "FLOAT(2,2)")
    private Float mainGoal;
    @Column(name = "is_admin", columnDefinition = "TINYINT(1)")
    private Boolean isAdmin;

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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIs_admin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


}
