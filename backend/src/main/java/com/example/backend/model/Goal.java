package com.example.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_goal", columnDefinition = "INT")
    private Integer id;

    @Column(name = "date", columnDefinition = "DATE")
    private Date date;
    @Column(name = "description", columnDefinition = "VARCHAR(64)")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user",
            foreignKey = @ForeignKey(name = "fk_goal_user"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
