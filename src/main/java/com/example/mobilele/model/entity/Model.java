package com.example.mobilele.model.entity;

import com.example.mobilele.model.entity.emumaration.Category;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name ="start_year")
    private Integer startYear;

    @Column(name ="end_year")
    private Integer endYear;

    @ManyToOne
    private Brand brand;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }




}
