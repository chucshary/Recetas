package shary.recetas.activity.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import shary.recetas.R;
import shary.recetas.activity.SQLite.ColumnsTable;
import shary.recetas.activity.SQLite.Querys;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_1_Step extends Fragment {
    private ColumnsTable columnsTable = new ColumnsTable();
    private ListView ingredientsListView;
    public List<String> listado;
    public List<String> listado2;
    private ActionBar ab;
    private String id;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab1_step, container, false);
        ingredientsListView = (ListView) rootView.findViewById(R.id.ingredients_list_view);
        
        ingredientes();
        return rootView;
    }

    public String getIdRecipe() {
        SharedPreferences sharedPreferences = rootView.getContext().getSharedPreferences("Receta", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("idReceta", "Nada");
        System.out.println("ID DE RECETA A BUSCAR " + id);
        return id;
    }

    public void ingredientes() {
        Querys querys = new Querys(rootView.getContext(), "ingredients");
        querys.listado(columnsTable.getColumnsTableIngredients(), 1, "recipe_id", getIdRecipe());
        listado = querys.lista;
        querys.listado(columnsTable.getColumnsTableIngredients(), 2, "recipe_id", getIdRecipe());
        listado2 = querys.lista;

        ArrayList<String> array3 = new ArrayList<String>(listado.size());
        for (int i = 0; i < listado.size(); i++) {
            array3.add(listado2.get(i) + " " + listado.get(i));
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, array3);
        ingredientsListView.setAdapter(itemsAdapter);
    }
}
