package shary.recetas.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shary.recetas.R;

/**
 * Created by Shary on 27/06/2015.
 */
public class RecetasBusquedaFragment extends Fragment {
    View rootView;
    String busquedaF;
    String busquedaV;
    String busquedaC;
    String busquedaCo;
    String busquedaCa;
    String busquedaL;
    String busquedaO;


    public RecetasBusquedaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recetas_busqueda, container, false);

        SharedPreferences sharedPreferences = rootView.getContext().getSharedPreferences("Ingredients", Context.MODE_PRIVATE);
        busquedaF = sharedPreferences.getString("Frutas", "Nada");
        busquedaV = sharedPreferences.getString("Verduras", "Nada");
        busquedaC = sharedPreferences.getString("Cereales", "Nada");
        busquedaCo = sharedPreferences.getString("Condimentos", "Nada");
        busquedaCa = sharedPreferences.getString("Carnes", "Nada");
        busquedaL = sharedPreferences.getString("Lacteos", "Nada");
        busquedaO = sharedPreferences.getString("Extras", "Nada");
        System.out.println("otros tab busqueda " + busquedaO);

        String busqueda = busquedaF
                + busquedaV
                + busquedaC
                + busquedaCo
                + busquedaCa
                + busquedaL
                + busquedaO;
        System.out.println("Busqueda receta " + busqueda);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
