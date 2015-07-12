package shary.recetas.activity.rest;

/**
 * Created by Shary on 06/07/2015.
 */
public class Recipe {
    private Integer id;
    private String nombre;
    private String categoria;
    private boolean favorito;
    private String tipo;

    public Recipe(String nombre, String categoria, boolean favorito, String tipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.favorito = favorito;
        this.tipo = tipo;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
