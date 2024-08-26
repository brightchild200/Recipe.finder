package com.example;

public class Recipe {
    private String name;
    private String[] ingredients;
    private String instructions;

    public Recipe(String name, String[] ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public boolean containsIngredient(String ingredient) {
        for (String ing : ingredients) {
            if (ing.equalsIgnoreCase(ingredient)) {
                return true;
            }
        }
        return false;
    }
}
