select Recipes.Name, Ingredients.name from Ingredients
join Recipes
where Ingredients.name like "%garlic%"
and Ingredients.Recipe_idRecipe = Recipes.idRecipe