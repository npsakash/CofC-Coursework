select Recipes.name, Nutrition.*
from Recipes
join Nutrition
Where Recipes_idRecipe Is null
and Recipes.Nutrition_idNutrition = idNutrition