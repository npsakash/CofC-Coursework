select Nutrition.*
from Recipes
join Nutrition
Where Recipes.name = "Ricotta Pie"
and Recipes.name.Nutrition_idNutrition = Nutrition_idNutrition
