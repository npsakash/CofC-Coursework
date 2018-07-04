select Ingredients.name from Recipes
join Ingredients
where Recipes.name = "pastry"
and Ingredients.Recipe_idRecipe = Recipes.idRecipe