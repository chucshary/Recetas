package shary.recetas.activity;

import android.graphics.Bitmap;

/**
 * Created by Shary on 25/07/2015.
 */
public class RecetaAux {
    Bitmap idPhoto;
    String name;
    String category;

    public RecetaAux(Bitmap idPhoto, String name, String category) {
        this.idPhoto = idPhoto;
        this.name = name;
        this.category = category;
    }

    public Bitmap getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Bitmap idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
