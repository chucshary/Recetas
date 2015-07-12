package shary.recetas.activity.RecipeClass;

/**
 * Created by Shary on 06/07/2015.
 */
public class ColumnsTable {
    private String[] columnsTableRecipe = {"id", "nombre", "tipo", "categoria", "duracion" ,"porcion"};
    private String[] columnsTableIngredients = {"id", "nombre","cantidad", "clasificacion","recipe_id"};
    private String[] columnsTableStep = {"id", "paso", "paso_descripcion", "id_step_recipe_id"};

    public String[] getColumnsTableRecipe() {
        return columnsTableRecipe;
    }

    public void setColumnsTableRecipe(String[] columnsTableRecipe) {
        this.columnsTableRecipe = columnsTableRecipe;
    }

    public String[] getColumnsTableIngredients() {
        return columnsTableIngredients;
    }

    public void setColumnsTableIngredients(String[] columnsTableIngredients) {
        this.columnsTableIngredients = columnsTableIngredients;
    }

    public String[] getColumnsTableStep() {
        return columnsTableStep;
    }

    public void setColumnsTableStep(String[] columnsTableStep) {
        this.columnsTableStep = columnsTableStep;
    }
}
