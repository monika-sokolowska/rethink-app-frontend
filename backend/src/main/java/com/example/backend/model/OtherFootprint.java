package com.example.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "other_footprint")
public class OtherFootprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_other_footprint", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(name = "footprint", columnDefinition = "FLOAT(4,2)")
    private Float footprint;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_daily_footprint", referencedColumnName = "id_daily_footprint",
            foreignKey = @ForeignKey(name = "fk_other_daily_footprint"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private DailyFootprint dailyFootprint;

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


    public Float getFootprint() {
        return footprint;
    }

    public void setFootprint(Float footprint) {
        this.footprint = footprint;
    }

    public DailyFootprint getDailyFootprint() {
        return dailyFootprint;
    }

    public void setDailyFootprint(DailyFootprint dailyFootprint) {
        this.dailyFootprint = dailyFootprint;
    }
}