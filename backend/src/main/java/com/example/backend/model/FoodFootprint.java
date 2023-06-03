package com.example.backend.model;

import com.example.backend.util.Meal;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "food_footprint")
public class FoodFootprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_food_footprint", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;

    @Enumerated(EnumType.STRING)
    private Meal meal;

    @Column(name = "footprint", columnDefinition = "FLOAT(4,2)")
    private Float footprint;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_daily_footprint", referencedColumnName = "id_daily_footprint",
            foreignKey = @ForeignKey(name = "fk_food_daily_footprint"))
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

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
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