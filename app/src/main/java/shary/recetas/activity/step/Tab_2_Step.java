package shary.recetas.activity.step;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import shary.recetas.R;
import shary.recetas.activity.SQLite.ColumnsTable;
import shary.recetas.activity.SQLite.Querys;
import shary.recetas.activity.SQLite.Variables;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_2_Step extends Fragment implements OnClickListener, TextToSpeech.OnInitListener {
    private static final int MY_DATA_CHECK_CODE = 1234;
    private static final String TAG = "TextToSpeechDemo";
    private ColumnsTable columnsTable = new ColumnsTable();
    private Variables variables = new Variables();
    private ListView ingredientsListView;
    private TextToSpeech t1;
    public List<String> listado;
    public List<String> listado2;
    SharedPreferences sharedPreferences;
    public String instruccioness = "";
    private ActionBar ab;
    String id = "";
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab2_step, container, false);
        ingredientsListView = (ListView) rootView.findViewById(R.id.instruccion_list_view);
        instrucciones();
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.btn_voice);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Querys querys = new Querys(rootView.getContext(), "step");
                querys.listado(columnsTable.getColumnsTableStep(), 2, "id_step_recipe_id", getIdRecipe());
                listado2 = querys.lista;
                String texto = "";
                for (int i = 0; i < listado.size(); i++) {
                    texto += listado2.get(i);
                }
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        return rootView;
    }

    public String getIdRecipe() {
        SharedPreferences sharedPreferences = rootView.getContext().getSharedPreferences("Receta", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("idReceta", "Nada");
        System.out.println("ID DE RECETA A BUSCAR " + id);
        return id;
    }

    public void instrucciones() {
        Querys querys = new Querys(rootView.getContext(), "step");
        querys.listado(columnsTable.getColumnsTableStep(), 1, "id_step_recipe_id", getIdRecipe());
        listado = querys.lista;
        querys.listado(columnsTable.getColumnsTableStep(), 2, "id_step_recipe_id", getIdRecipe());
        listado2 = querys.lista;

        ArrayList<String> array3 = new ArrayList<String>(listado.size());
        for (int i = 0; i < listado.size(); i++) {
            array3.add(listado.get(i) + ".- " + listado2.get(i));
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, array3);
        ingredientsListView.setAdapter(itemsAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                t1 = new TextToSpeech(getActivity(), this);
                Locale locSpanish = new Locale("spa", "MEX");
                t1.setLanguage(locSpanish);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown!
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            t1 = new TextToSpeech(getActivity(), this);
            Locale locSpanish = new Locale("spa", "MEX");
            int result = t1.setLanguage(locSpanish);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
            } else {
            }
        } else {
            Log.e(TAG, "Could not initialize TextToSpeech.");
        }
    }
}
