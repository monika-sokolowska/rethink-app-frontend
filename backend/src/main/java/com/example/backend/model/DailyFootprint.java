package com.example.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "daily_footprint")
public class DailyFootprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_daily_footprint", columnDefinition = "INT")
    private Integer id;

    @Column(name = "date", columnDefinition = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user",
            foreignKey = @ForeignKey(name = "fk_daily_footprint_user"))
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
}
