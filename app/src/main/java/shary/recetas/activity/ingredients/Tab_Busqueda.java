package shary.recetas.activity.ingredients;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shary.recetas.R;
import shary.recetas.activity.SQLite.Variables;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_Busqueda extends Fragment {
    private TextView listadoIng;
    static Variables variables = new Variables();
    String busquedaF;
    String busquedaV;
    String busquedaC;
    String busquedaCo;
    String busquedaCa;
    String busquedaL;
    String busquedaO;
    View rootView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_search_ingredients, container, false);
        listadoIng = (TextView) rootView.findViewById(R.id.txtsearch);
        SharedPreferences sharedPreferences = rootView.getContext().getSharedPreferences("Ingredients", Context.MODE_PRIVATE);
        busquedaF = sharedPreferences.getString("Frutas", "Nada");
        busquedaV = sharedPreferences.getString("Verduras", "Nada");
        busquedaC = sharedPreferences.getString("Cereales", "Nada");
        busquedaCo = sharedPreferences.getString("Condimentos", "Nada");
        busquedaCa = sharedPreferences.getString("Carnes", "Nada");
        busquedaL = sharedPreferences.getString("Lacteos", "Nada");
        busquedaO = sharedPreferences.getString("Otros", "Nada");

        System.out.println("ENTRO BUSQUEDA " + busquedaF + " /n "
                + busquedaV + " /n "
                + busquedaC + " /n "
                + busquedaCo + " /n "
                + busquedaCa + " /n "
                + busquedaL + " /n "
                + busquedaO + " /n ");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Frutas", "");
        editor.putString("Verduras", "");
        editor.putString("Cereales", "");
        editor.putString("Condimentos", "");
        editor.putString("Carnes", "");
        editor.putString("Lacteos", "");
        editor.putString("Otros", "");
        editor.commit();


        busquedaF = sharedPreferences.getString("Frutas", "Nada");
        busquedaV = sharedPreferences.getString("Verduras", "Nada");
        busquedaC = sharedPreferences.getString("Cereales", "Nada");
        busquedaCo = sharedPreferences.getString("Condimentos", "Nada");
        busquedaCa = sharedPreferences.getString("Carnes", "Nada");
        busquedaL = sharedPreferences.getString("Lacteos", "Nada");
        busquedaO = sharedPreferences.getString("Otros", "Nada");

        System.out.println("ENTRO BUSQUEDA SALIDA " + busquedaF + " /n "
                + busquedaV + " /n "
                + busquedaC + " /n "
                + busquedaCo + " /n "
                + busquedaCa + " /n "
                + busquedaL + " /n "
                + busquedaO + " /n ");

        return rootView;
    }
}
