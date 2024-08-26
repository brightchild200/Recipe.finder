package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class RecipeServlet extends HttpServlet {
    private List<Recipe> recipes;

    @Override
    public void init() throws ServletException {
        recipes = new ArrayList<>();
        // Add some sample recipes
        recipes.add(new Recipe("Pasta Carbonara", new String[]{"pasta", "eggs", "bacon", "parmesan"}, "Cook pasta, mix with eggs, bacon, and parmesan."));
        recipes.add(new Recipe("Chicken Salad", new String[]{"chicken", "lettuce", "tomatoes", "cucumbers", "dressing"}, "Mix chicken with vegetables and dressing."));
        recipes.add(new Recipe("Vegetable Stir-fry", new String[]{"carrots", "broccoli", "bell peppers", "soy sauce"}, "Stir-fry vegetables with soy sauce."));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ingredient = req.getParameter("ingredient");
        List<Recipe> foundRecipes = new ArrayList<>();

        if (ingredient != null && !ingredient.trim().isEmpty()) {
            for (Recipe recipe : recipes) {
                if (recipe.containsIngredient(ingredient)) {
                    foundRecipes.add(recipe);
                }
            }
        }

        req.setAttribute("recipes", foundRecipes);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
