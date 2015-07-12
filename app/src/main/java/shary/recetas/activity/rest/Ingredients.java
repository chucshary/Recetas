package shary.recetas.activity.rest;

/**
 * Created by Shary on 06/07/2015.
 */
public class Ingredients {
    private Integer id;
    private String nombre;

    public Ingredients(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
