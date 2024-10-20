package recipefinder;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeFinderGUI extends JFrame {
    private JComboBox<String> categoryComboBox;
    private JList<String> recipeList;
    private JTextArea recipeDetailsArea;
    private CardLayout cardLayout;
    private JPanel cardsPanel;
    private JTextField searchField;
    private JLabel recipeImageLabel; // Added for image rendering

    public RecipeFinderGUI() {
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up card layout to switch between recipe list and details
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        add(cardsPanel, BorderLayout.CENTER);

        Font timesNewRomanFont = new Font("Times New Roman", Font.PLAIN, 18); // For Buttons, Labels, and TextFields
        Font serifFont = new Font("Serif", Font.PLAIN, 18); // For Other Components

        JButton filterButton = new JButton("Filter");
        filterButton.setFont(timesNewRomanFont); // Applying Times New Roman font
        filterButton.setBackground(Color.decode("#798645"));  // Filter button background color
        filterButton.setForeground(Color.WHITE);  // Filter button font color
        
        JLabel recipeLabel = new JLabel("Recipe");
        recipeLabel.setFont(timesNewRomanFont); // Applying Times New Roman font

        searchField = new JTextField(20); // Updated for search functionality
        searchField.setFont(timesNewRomanFont); 
        searchField.setBackground(Color.decode("#FEFAE0"));  // Background color for search field

        JTextArea recipeDetails = new JTextArea();
        recipeDetails.setFont(serifFont); // Applying Serif font for recipe details

        Font recipeFont = new Font("Times New Roman", Font.PLAIN, 18);
        JTextArea recipeArea = new JTextArea();
        recipeArea.setFont(recipeFont); // Set 20-point font for recipes

        // Create recipe list page
        JPanel recipeListPage = new JPanel(new BorderLayout());
        recipeListPage.setBackground(Color.decode("#FEFAE0"));  // Set background color for recipe list page

        // Panel for category selection, search, and button in the center
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.decode("#FEFAE0"));  // Top panel background color

        // Category selection
        categoryComboBox = new JComboBox<>(new String[]{"All", "Breakfast", "Lunch", "Dinner"});
        categoryComboBox.setBackground(Color.decode("#798645"));
        topPanel.add(categoryComboBox);

        // Add search field and filter button
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(filterButton);

        // Recipe list
        DefaultListModel<String> recipeListModel = new DefaultListModel<>();
        recipeList = new JList<>(recipeListModel);
         recipeList.setBackground(Color.decode("#FEFAE0"));   // Set background color of the recipe list

        // Set the font to Times New Roman with size 20
        recipeList.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // Add the recipe list to the scroll pane and page layout
        JScrollPane scrollPane = new JScrollPane(recipeList);
        recipeListPage.add(topPanel, BorderLayout.NORTH);
        recipeListPage.add(scrollPane, BorderLayout.CENTER);
        cardsPanel.add(recipeListPage, "RecipeList");

        // Recipe details page
        JPanel recipeDetailsPage = new JPanel(new BorderLayout());
        recipeDetailsArea = new JTextArea();
        recipeDetailsArea.setEditable(false);
        recipeDetailsArea.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // Recipe font set to 20 points

        // Image label to display recipe images
        recipeImageLabel = new JLabel();
        recipeImageLabel.setHorizontalAlignment(SwingConstants.CENTER);  // Center the image

        // Adding Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(timesNewRomanFont);
        backButton.addActionListener(e -> cardLayout.show(cardsPanel, "RecipeList"));

        recipeDetailsPage.add(backButton, BorderLayout.SOUTH);  // Back button added
        recipeDetailsPage.add(new JScrollPane(recipeDetailsArea), BorderLayout.CENTER);
        recipeDetailsPage.add(recipeImageLabel, BorderLayout.NORTH);  // Image added at the top
        cardsPanel.add(recipeDetailsPage, "RecipeDetails");

        // Add action listeners
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterRecipes();
            }
        });

        recipeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    showRecipeDetails(recipeList.getSelectedValue());
                }
            }
        });

        // Initial load of recipes
        loadRecipes();

        // Show the main window
        setVisible(true);
    }

    // Load all recipes
    private void loadRecipes() {
        DefaultListModel<String> model = (DefaultListModel<String>) recipeList.getModel();
        model.clear();
        for (Recipe recipe : Recipe.getAllRecipes()) {
            model.addElement(recipe.name);
        }
    }

    // Filter recipes based on selected category and search field
    private void filterRecipes() {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String searchTerm = searchField.getText().toLowerCase(); // New logic for search

        DefaultListModel<String> model = (DefaultListModel<String>) recipeList.getModel();
        model.clear();

        boolean recipeFound = false;  // Flag to check if any recipe matches the criteria

        for (Recipe recipe : Recipe.getAllRecipes()) {
            if ((selectedCategory.equals("All") || recipe.mealCategory.equals(selectedCategory))
                    && (searchTerm.isEmpty() || recipe.name.toLowerCase().contains(searchTerm))) {
                model.addElement(recipe.name);
                recipeFound = true;
            }
        }

        if (!recipeFound) {
            JOptionPane.showMessageDialog(this, "No recipes found for your search.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Show details of the selected recipe, including the image
    private void showRecipeDetails(String recipeName) {
        for (Recipe recipe : Recipe.getAllRecipes()) {
            if (recipe.name.equals(recipeName)) {
                JPanel recipeDetailsPanel = new JPanel();
                recipeDetailsPanel.setLayout(new BorderLayout());

                // Load and scale the image
                ImageIcon recipeImage = new ImageIcon(recipe.imagePath);
                Image image = recipeImage.getImage(); // Get the image
                Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Scale the image to 200x200
                recipeImage = new ImageIcon(scaledImage); // Update the ImageIcon with the scaled image

                // Set the image in a JLabel
                JLabel imageLabel = new JLabel(recipeImage);

                // Create a JTextPane to display the recipe details
                JTextPane recipeTextPane = new JTextPane();
                recipeTextPane.setContentType("text/html"); // HTML content for text wrapping

                // Build the HTML content for ingredients and preparation steps
                StringBuilder recipeContent = new StringBuilder();
                recipeContent.append("<html><body style='font-family:Times New Roman; font-size:20px;'>");
                recipeContent.append("<h1>").append(recipe.name).append("</h1>");
                recipeContent.append("<b>Ingredients:</b><ul>");
                for (String ingredient : recipe.ingredients) {
                    recipeContent.append("<li>").append(ingredient).append("</li>");
                }
                recipeContent.append("</ul>");
                recipeContent.append("<b>Preparation Steps:</b><ol>");
                for (String step : recipe.preparationSteps) {
                    recipeContent.append("<li>").append(step).append("</li>");
                }
                recipeContent.append("</ol></body></html>");

                // Set the content in the JTextPane
                recipeTextPane.setText(recipeContent.toString());
                recipeTextPane.setEditable(false); // Read-only text

                // Create a panel for the image and text
                JPanel imageTextPanel = new JPanel(new BorderLayout());
                imageTextPanel.add(imageLabel, BorderLayout.WEST); // Image on the left
                imageTextPanel.add(new JScrollPane(recipeTextPane), BorderLayout.CENTER); // Text on the right

                // Add the back button and image/text panel to the recipe details panel
                recipeDetailsPanel.add(imageTextPanel, BorderLayout.CENTER); // Add the image and text panel

                // Adding Back button
            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // Set the font for the back button
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardsPanel, "RecipeList");  // Switch back to the recipe list page
                }
            });

            // Add the back button at the bottom of the recipe details page
            recipeDetailsPanel.add(backButton, BorderLayout.SOUTH); 

                // Show the recipe details page
                cardsPanel.add(recipeDetailsPanel, "RecipeDetails");
                cardLayout.show(cardsPanel, "RecipeDetails");

                break;
            }
        }
    }

    public static void main(String[] args) {
        new RecipeFinderGUI();
    }
}
