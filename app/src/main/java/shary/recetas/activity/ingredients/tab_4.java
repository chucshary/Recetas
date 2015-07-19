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
public class Tab_4 extends Fragment {
    private ColumnsTable columnsTable = new ColumnsTable();
    private Variables variables = new Variables();
    private ListView ingredientsListView;
    public List<String> listado;
    public String condimentos = "";
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab4_ingredients, container, false);
        ingredientsListView = (ListView) rootView.findViewById(R.id.ingredients_list_view);
        condimento();
        return rootView;
    }

    public void condimento() {
        Querys querys = new Querys(rootView.getContext(), "ingredients");
        querys.listadoDistict("nombre", 0, "clasificacion", "CONDIMENTO");
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
        condimentos = "";
        for (int i = 0; i < listado.size(); i++) {
            if (ingredientsListView.getCheckedItemPositions().get(i) == true) {
                condimentos += ingredientsListView.getItemAtPosition(i).toString() + ",";
            }
        }
        variables.setCondimento(condimentos);
        System.out.println("condimentos  " + variables.getCondimento());
    }
}
