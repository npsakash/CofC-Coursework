select Ingredients.name from Recipes
join Ingredients
where Recipes.Name = "Beef Parmesan with Garlic Angel Hair Pasta"
and Ingredients.Recipe_idRecipe = Recipes.idRecipe