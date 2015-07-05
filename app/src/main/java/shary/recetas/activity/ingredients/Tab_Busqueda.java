package shary.recetas.activity.ingredients;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shary.recetas.R;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_Busqueda extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_search_ingredients, container, false);
        return rootView;
    }
}
