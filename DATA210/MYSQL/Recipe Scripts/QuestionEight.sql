select StepNumber, Instruction from Recipes
join PreparationSteps
where Recipes.Name = "Zuppa Inglese"
and PreparationSteps.Recipe_idRecipe = Recipes.idRecipe
Order by StepNumber asc	