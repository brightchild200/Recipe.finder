package recipefinder;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    String name;
    List<String> ingredients;
    List<String> preparationSteps;
    String mealCategory;
    public String imagePath; 

    // Constructor
    public Recipe(String name, List<String> ingredients, List<String> preparationSteps, String mealCategory, String imagePath) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationSteps = preparationSteps;
        this.mealCategory = mealCategory;
         this.imagePath = imagePath;
    }

    // Static method to get all recipes
    
    public static List<Recipe> getAllRecipes() {
        return Arrays.asList(
            new Recipe("Poha",
                Arrays.asList("2 cups poha (flattened rice)", "1 medium sized chopped onion", "1 or 2 green chillies(slit or chopped)", "1 small potato (peeled and chopped into small cubes)", "8 - 10 curry leaves", "1/2 tsp cumin seeds", "1/2 tsp mustard seeds", "Coriander leaves (for garnish)", "1/2 tbsp oil", "1/4 tsp turmeric powder", "2 tbsp peanuts", "Salt to taste", "1 tsp sugar (optional, for a slight sweetness)"),
                Arrays.asList(
                    "Place the poha in a colander and rinse it under running water for 10-15 seconds.\nDrain the water completely and let the poha sit for 5-10 minutes to soften.\nSprinkle a pinch of turmeric and salt over the poha, and mix gently.",
                    "Heat oil in a pan on medium heat. Add mustard seeds and cumin seeds, and let them splutter.\nAdd the peanuts and fry until they turn golden brown. Remove and set aside.\nAdd chopped potatoes to the pan and sauté until they become soft and lightly golden.",
                    "Add curry leaves, chopped green chilies, and onions to the pan with the potatoes. Sauté until the onions turn soft and translucent.\nAdd turmeric powder and stir well.\nNow, add the softened poha to the pan, and gently mix everything together so the spices coat the poha evenly.",
                    "Add salt, sugar (optional), and fried peanuts. Stir gently for 2-3 minutes on low heat until everything is well combined.\nTurn off the heat and squeeze fresh lemon juice over the poha.\nGarnish with chopped coriander leaves and sev (optional).",
                    "Serve the poha hot with a side of tea or coffee.\nEnjoy your light and flavorful Poha!"),
                "Breakfast" , "Poha.jpg"
            ),
            
new Recipe(
    "Palak Paneer",
    Arrays.asList(
        "For Marination:",  
        "250g paneer (cut into cubes)",  
        "1/2 tsp turmeric powder",  
        "1/2 tsp red chili powder",  
        "1/4 tsp salt",  
        "1 tbsp lemon juice",  

        "For Curry:",
        "2 tbsp oil (or ghee)",  
        "1 tsp cumin seeds",  
        "1 medium onion (finely chopped)",  
        "2 medium tomatoes (pureed)",  
        "4-5 garlic cloves (minced)",  
        "1-inch ginger (grated)",  
        "2 green chilies (slit)",  
        "1/2 tsp turmeric powder",  
        "1 tsp coriander powder",  
        "1/2 tsp cumin powder",  
        "1/2 tsp garam masala",  
        "Salt to taste",  
        "300g fresh spinach leaves (blanched and pureed)",  
        "1/4 cup cream or yogurt (optional, for a rich texture)",  
        "Fresh cream and coriander leaves for garnish"
    ),
    Arrays.asList(
        "In a bowl, marinate the paneer cubes with turmeric, red chili powder, salt, and lemon juice. \nSet aside for 10-15 minutes.",
        "Heat 2 tbsp oil or ghee in a pan. Lightly fry the marinated paneer cubes until golden on each side. \nRemove and set aside.",
        "In the same pan, add cumin seeds and allow them to splutter. \nAdd chopped onions and sauté until golden brown.",
        "Add garlic, ginger, and green chilies. Sauté for 1-2 minutes until fragrant.",
        "Add turmeric, coriander powder, cumin powder, and garam masala. Stir well for 30 seconds.",
        "Add the tomato puree and cook until the oil starts to separate from the masala.",
        "Add the spinach puree to the pan. Stir well and simmer for 5 minutes.",
        "Carefully add the fried paneer cubes and simmer for another 5 minutes to absorb the flavors.",
        "Add cream or yogurt (if using) and stir. Adjust salt as needed.",
        "Garnish with a drizzle of cream and fresh coriander leaves. \nServe hot with naan, roti, or rice.\n\nEnjoy your delicious Palak Paneer!"
    ),  "Lunch", "palakpaneer.jpeg"
),


new Recipe(
    "Thai Green Curry",
    Arrays.asList(
        "For Marination:",
        "500g chicken thighs (boneless, skinless, cut into pieces)",  
        "1 tsp salt",  
        "1/2 tsp white pepper",  
        "1 tbsp lime juice",  

        "For Curry:",
        "2 tbsp oil (vegetable or coconut oil)",  
        "2 tbsp green curry paste (store-bought or homemade)",  
        "1 medium onion (sliced)",  
        "1 bell pepper (sliced)",  
        "1 cup coconut milk",  
        "1/2 cup chicken broth or water",  
        "4-5 kaffir lime leaves (optional)",  
        "1 stalk lemongrass (cut into 2-inch pieces)",  
        "2-3 Thai green chilies (slit)",  
        "1 tbsp fish sauce",  
        "1 tsp sugar",  
        "1/2 tsp salt",  
        "1/2 cup Thai basil leaves",  
        "Fresh coriander for garnish",  
        "Lime wedges (for serving)"
    ),
    Arrays.asList(
        "In a bowl, marinate the chicken with salt, white pepper, and lime juice. \nSet aside for 15-20 minutes.",
        "Heat 2 tbsp oil in a pan. Add the green curry paste and sauté for 1-2 minutes until fragrant.",
        "Add sliced onions and bell peppers. Stir-fry for another 2-3 minutes.",
        "Pour in the coconut milk and chicken broth. Stir well and bring to a simmer.",
        "Add the marinated chicken pieces to the pan along with kaffir lime leaves, lemongrass, and green chilies.",
        "Season with fish sauce, sugar, and salt. Let it simmer on low heat for 10-12 minutes until the chicken is cooked through.",
        "Stir in Thai basil leaves and cook for another minute.",
        "Garnish with fresh coriander leaves. \nServe hot with steamed jasmine rice and lime wedges.\n\nEnjoy your flavorful Thai Green Curry!"
    ), "Dinner", "thaigreencurry.jpeg"
),

            new Recipe("Medu Vada",
                Arrays.asList("1 cup urad dal", "Lots of Water", "Some rava", "1 tablespoon chopped curry leaves", "1 teaspoon finely chopped green chillies", "1 teaspoon finely chopped ginger", "½ teaspoon cumin seeds", "½ teaspoon lightly crushed black pepper", "½ teaspoon salt or as required", "Oil"),
                Arrays.asList(
                    "Rinse 1 cup urad dal a few times in water. \nThen soak the lentils in 2.5 to 3 cups water for at least 4 to 5 hours or up to overnight.",
                    "Drain and discard the water. Add the soaked urad dal to a grinder jar.\nAdd 3 to 4 tablespoons fresh water or as needed.\n!!! Do not add too much water while grinding. !!!",
                    "Begin to grind or blend the urad dal to a smooth batter.\nThe batter should be fluffy and thick.\nRemove the batter into a big bowl or vessel. Then briskly whip with a spatula, spoon or a wired whisk for 2 to 3 minutes.\nThis aerates the batter and gives it a light, fluffy texture.",
                    "Add curry leaves, green chillies, ginger, cumin seeds, black pepper and salt and mix them well.",
                    "Take a bowl of water. Apply some water from the bowl on both your palms.\nTake some batter in your right palm from the bowl.\nGive it a round shape by moving it in a circular position in the right hand.\nIn a kadai, heat oil over medium heat.\nOnce the oil becomes hot, slide the medu vada gently into the hot oil.\nFry the medhu vadai till crisp and golden.\nServe Medu Vada or Garelu or Uzhunnu Vada hot or warm with sambar and coconut chutney. Enjoy!"),
                "Breakfast", "meduvada.jpeg"
            ),
            new Recipe("Rava Dosa",
                Arrays.asList("1/2 cup fine rava", "1/2 rice flour", "1/4 maida", "1 tbsp curd", "water"),
                Arrays.asList(
                    "Take rava in a bowl and add maida, rice flour and curd in it to prepare a lump free batter.",
                    "Cover and rest it for 20 mins.",
                    "Heat a frying pan and grease it with oil",
                    "When the pan is heated, stir the batter and pour the batter on it and reduce the flame.",
                    "Once the batter is cooked fully apply ghee on it."
                ),
                "Breakfast", "ravadosa.jpg"
            ),
            new Recipe("Garlic Bread",
                Arrays.asList("bread", "garlic", "butter", "parsley"),
                Arrays.asList(
                    "Preheat the oven to 375°F (190°C).",
                    "Mix butter, minced garlic, and chopped parsley.",
                    "Spread the mixture on bread slices.",
                    "Bake in the oven for 10-15 minutes until golden."
                ),
                "Dinner", "garlicbread.jpeg"
            ),
            new Recipe("Fish Curry",
                Arrays.asList("For Marination:", "500g fish fillets (any firm fish like Rohu, Kingfish, Pomfret, or Catfish)", "1 tsp turmeric powder", "1 tsp red chili powder", "1/2 tsp salt", "1 tbsp lemon juice", "For Curry:", "2 tbsp oil (mustard oil preferred)", "1 tsp cumin seeds", "1 medium onion (finely chopped)", "2 medium tomatoes (pureed or finely chopped)", "4-5 garlic cloves (minced)", "1-inch ginger (grated)", "2 green chilies (slit)", "1/2 tsp turmeric powder", "1 tsp red chili powder", "1 tsp coriander powder", "1/2 tsp garam masala", "1/2 tsp cumin powder", "Salt to taste", "1/2 cup coconut milk (optional, for South Indian style) or water", "Fresh coriander leaves for garnish"),
                Arrays.asList(
                    "In a bowl, mix fish fillets with turmeric, red chili powder, salt, and lemon juice.\nSet aside for 15-20 minutes.\nHeat 2 tbsp oil in a pan. Fry the marinated fish for 2-3 minutes on each side until lightly golden.\nRemove and set aside on a plate.",
                    "In the same pan, add cumin seeds and allow them to splutter.\nAdd chopped onions and sauté until golden brown.\nAdd ginger, garlic, and green chilies.\nSauté for 1-2 minutes until fragrant.\nAdd turmeric, red chili powder, coriander powder, cumin powder, and garam masala. Stir well for 30 seconds.\nAdd tomato puree and cook until the oil starts to separate from the masala.",
                    "Add coconut milk or water to the masala, and let it simmer for 5 minutes on low heat.\nCarefully add the fried fish pieces to the curry. Let it simmer for another 5-6 minutes until the fish absorbs the flavors.\nGarnish with fresh coriander leaves.\nServe hot with steamed rice, naan, or chapati.\n\nEnjoy your delicious fish curry!"
                ),
                "Lunch", "fishcurry.jpeg"
            ),
            new Recipe("Tomato Soup",
                Arrays.asList("tomato", "garlic", "onion", "olive oil", "vegetable broth"),
                Arrays.asList(
                    "Heat olive oil in a pot and sauté chopped onions and garlic.",
                    "Add chopped tomatoes and vegetable broth.",
                    "Simmer for 20-30 minutes.",
                    "Blend until smooth and season to taste."
                ),
                "Lunch", "tomatosoup.jpg"
            )
        );
    }
}
