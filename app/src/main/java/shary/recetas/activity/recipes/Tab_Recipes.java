package shary.recetas.activity.recipes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import shary.recetas.R;
import shary.recetas.activity.SQLite.ColumnsTable;
import shary.recetas.activity.SQLite.Querys;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_Recipes extends Fragment {
    private ColumnsTable columnsTable = new ColumnsTable();
    private ListView recipeListView;
    public List<String> listado;
    View rootView;


    public static Tab_Recipes newInstance(int i) {
        Tab_Recipes myFragment = new Tab_Recipes();
        Bundle args = new Bundle();
        args.putInt("someInt", i);
        myFragment.setArguments(args);
        System.out.println("AQUI CONTRUCTOR " + i);
        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_recipes, container, false);
        recipeListView = (ListView) rootView.findViewById(R.id.recipes_list_view);
        switch (getArguments().getInt("someInt")) {
            case 0:
                desayuno();
                break;
            case 1:
                pasta();
                break;
            case 2:
                entrada();
                break;
            case 3:
                platoFuerte();
                break;
            case 4:
                postre();
                break;
        }
        return rootView;
    }

    public void desayuno() {
        Querys querys = new Querys(rootView.getContext(), "recipe");
        querys.listado(columnsTable.getColumnsTableRecipe(), 1, "tipo", "DESAYUNO");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, listado);
        recipeListView.setAdapter(itemsAdapter);
    }

    public void pasta() {
        Querys querys = new Querys(rootView.getContext(), "recipe");
        querys.listado(columnsTable.getColumnsTableRecipe(), 1, "tipo", "PASTA");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, listado);
        recipeListView.setAdapter(itemsAdapter);
    }

    public void entrada() {
        Querys querys = new Querys(rootView.getContext(), "recipe");
        querys.listado(columnsTable.getColumnsTableRecipe(), 1, "tipo", "ENTRADA");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, listado);
        recipeListView.setAdapter(itemsAdapter);
    }

    public void platoFuerte() {
        Querys querys = new Querys(rootView.getContext(), "recipe");
        querys.listado(columnsTable.getColumnsTableRecipe(), 1, "tipo", "PLATO FUERTE");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, listado);
        recipeListView.setAdapter(itemsAdapter);
    }

    public void postre() {
        Querys querys = new Querys(rootView.getContext(), "recipe");
        querys.listado(columnsTable.getColumnsTableRecipe(), 1, "tipo", "POSTRE");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, listado);
        recipeListView.setAdapter(itemsAdapter);
    }
}