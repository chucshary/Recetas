package shary.recetas.activity.recipes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import shary.recetas.R;
import shary.recetas.activity.rest.Recipe;
import shary.recetas.activity.rest.RecipeService;

/**
 * Created by Shary on 04/07/2015.
 */
public class Tab_Recipes extends Fragment {
    private RecipeService recipeService;
    private static final String TAG = "Recipe List Activity";
    View rootView;
    private ListView recipeListView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_recipes, container, false);
        recipeListView = (ListView) rootView.findViewById(R.id.recipes_list_view);

        String endpoint;
        endpoint = getString(R.string.api_endpoint);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .build();

        recipeService = restAdapter.create(RecipeService.class);
        getAllRecipes();
        return rootView;
    }

    private void getAllRecipes() {
        recipeService.getAllRecipes(new Callback<List<Recipe>>() {
            @Override
            public void success(List<Recipe> recipes, Response response) {
                String[] titles = new String[recipes.size()];
                String cadena = "";
                for (int i = 0; i < recipes.size(); i++) {
                    cadena = recipes.get(i).getNombre() + " ";
                    titles[i] = recipes.get(i).getNombre();
                }
                System.out.println("CADENA " + cadena);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, titles
                );
                recipeListView.setAdapter(adapter);
                recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getMessage());
                Toast.makeText(getActivity(),
                        "No se pudo obtener el Listado de recetas",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}


