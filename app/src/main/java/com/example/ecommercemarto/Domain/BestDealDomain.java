package com.example.ecommercemarto.Domain;

import java.io.Serializable;

public class BestDealDomain implements Serializable {
    String Description,ImagePath,Title;

    Long Price,Star,LocationId,Id,CategoryId;

    public BestDealDomain() {
    }

    public BestDealDomain(String description, String imagePath, String title, Long price, Long star, Long locationId, Long id, Long categoryId) {
        Description = description;
        ImagePath = imagePath;
        Title = title;
        Price = price;
        Star = star;
        LocationId = locationId;
        Id = id;
        CategoryId = categoryId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Long getStar() {
        return Star;
    }

    public void setStar(Long star) {
        Star = star;
    }

    public Long getLocationId() {
        return LocationId;
    }

    public void setLocationId(Long locationId) {
        LocationId = locationId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
}
