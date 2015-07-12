package shary.recetas.activity.rest;

/**
 * Created by Shary on 07/07/2015.
 */
public class RecipeIngredients {
    private Integer id;
    private Integer id_receta;
    private Integer id_ingrediente;
    private String cantidad;

    public RecipeIngredients(Integer id_receta, Integer id_ingrediente, String cantidad) {
        this.id_receta = id_receta;
        this.id_ingrediente = id_ingrediente;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_receta() {
        return id_receta;
    }

    public void setId_receta(Integer id_receta) {
        this.id_receta = id_receta;
    }

    public Integer getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(Integer id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
