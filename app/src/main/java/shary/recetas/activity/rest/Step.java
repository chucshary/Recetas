package shary.recetas.activity.rest;

/**
 * Created by Shary on 07/07/2015.
 */
public class Step {
    private Integer id;
    private Integer id_receta_step;
    private Integer paso;
    private String paso_descripcion;

    public Step(Integer id_receta_step, Integer paso, String paso_descripcion) {
        this.id_receta_step = id_receta_step;
        this.paso = paso;
        this.paso_descripcion = paso_descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_receta_step() {
        return id_receta_step;
    }

    public void setId_receta_step(Integer id_receta_step) {
        this.id_receta_step = id_receta_step;
    }

    public Integer getPaso() {
        return paso;
    }

    public void setPaso(Integer paso) {
        this.paso = paso;
    }

    public String getPaso_descripcion() {
        return paso_descripcion;
    }

    public void setPaso_descripcion(String paso_descripcion) {
        this.paso_descripcion = paso_descripcion;
    }
}
