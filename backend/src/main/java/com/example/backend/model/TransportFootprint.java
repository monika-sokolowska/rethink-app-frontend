package com.example.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "transport_footprint")
public class TransportFootprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_transport_footprint", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(name = "kilometers", columnDefinition = "FLOAT(6,2)")
    private Float kilometers;

    @Column(name = "footprint", columnDefinition = "FLOAT(5,2)")
    private Float footprint;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_daily_footprint", referencedColumnName = "id_daily_footprint",
            foreignKey = @ForeignKey(name = "fk_transport_daily_footprint"))
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


    public Float getKilometers() {
        return kilometers;
    }

    public void setKilometers(Float kilometers) {
        this.kilometers = kilometers;
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