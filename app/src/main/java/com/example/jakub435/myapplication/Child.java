package com.example.jakub435.myapplication;

/**
 * Created by Jakub435 on 2018-02-14.
 */

public class Child {

    private String Description;
    private String Nutrition;
    private String Ingredient;

    public String getIngredient() {
        return Ingredient;
    }

    public String getDescription() {
        return Description;
    }

    public String getNutrition() {
        return Nutrition;
    }

    public void setIngredient(String ingredient) {
        Ingredient = ingredient;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setNutrition(String nutrition) {
        Nutrition = nutrition;
    }
}