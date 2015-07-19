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
public class Tab_1 extends Fragment {
    private ColumnsTable columnsTable = new ColumnsTable();
    private ListView ingredientsListView;
    public List<String> listado;
    private Variables variables= new Variables();
    public String frutas = "";
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab1_ingredients, container, false);
        ingredientsListView = (ListView) rootView.findViewById(R.id.ingredients_list_view);
        fruta();
        return rootView;
    }

    public void fruta() {
        Querys querys = new Querys(rootView.getContext(), "ingredients");
        querys.listadoDistict("nombre", 0, "clasificacion", "FRUTA");
        listado = querys.lista;

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_multiple_choice, listado);
        ingredientsListView.setAdapter(itemsAdapter);
        ingredientsListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ingredientsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView checkedTextView = ((CheckedTextView) view);
                if (checkedTextView.isChecked() == true) {
                    verificar();
                } else {
                    verificar();
                }
            }
        });

    }

    public void verificar() {
        frutas = "";
        for (int i = 0; i < listado.size(); i++) {
            if (ingredientsListView.getCheckedItemPositions().get(i) == true) {
                frutas += ingredientsListView.getItemAtPosition(i).toString() + ",";
            }
        }
        variables.setFruta(frutas);
        System.out.println("frutas  " + variables.getFruta());
    }
}