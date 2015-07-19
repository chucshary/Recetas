package shary.recetas.activity.ingredients;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.List;

import shary.recetas.R;
import shary.recetas.activity.SQLite.ColumnsTable;
import shary.recetas.activity.SQLite.Querys;
import shary.recetas.activity.SQLite.Variables;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_Other_Ingredient extends Fragment {
    private ColumnsTable columnsTable = new ColumnsTable();
    private Variables variables = new Variables();
    private ListView ingredientsListView;
    public List<String> listado;
    public String otros = "";
    public CheckedTextView checkedTextView;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_other_ingredient, container, false);
        ingredientsListView = (ListView) rootView.findViewById(R.id.ingredients_list_view);
        other();
        return rootView;
    }

    public void other() {
        Querys querys = new Querys(rootView.getContext(), "ingredients_other");
        querys.listadoDistictNotClause("nombre", 0);
        listado = querys.lista;
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_multiple_choice, listado);
        ingredientsListView.setAdapter(itemsAdapter);
        ingredientsListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        otros = "";
        for (int i = 0; i < listado.size(); i++) {
            ingredientsListView.setItemChecked(i, true);
            otros += ingredientsListView.getItemAtPosition(i).toString() + ",";
            System.out.println("otros " + otros);
        }

        ingredientsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkedTextView = ((CheckedTextView) view);
                if (checkedTextView.isChecked() == false) {
                    verificar();
                } else {
                    verificar();
                }
            }
        });
    }

    public void verificar() {
        otros = "";
        for (int i = 0; i < listado.size(); i++) {
            if (ingredientsListView.getCheckedItemPositions().get(i) == true) {
                otros += ingredientsListView.getItemAtPosition(i).toString() + ",";
            }
        }
        variables.setOtro(otros);
        System.out.println("otros " + variables.getOtro());
    }
}
