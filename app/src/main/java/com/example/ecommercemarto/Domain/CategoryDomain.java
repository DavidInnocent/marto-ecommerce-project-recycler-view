package com.example.ecommercemarto.Domain;

public class CategoryDomain {
    private String ImagePath;
    private String Name;
    private int Id;

    public CategoryDomain(String imagePath, String name, int id) {
        ImagePath = imagePath;
        Name = name;
        Id = id;
    }

    public CategoryDomain() {

    }

    @Override
    public String toString() {
        return Name;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
