package shary.recetas.activity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import shary.recetas.R;
import shary.recetas.activity.RecipeClass.ColumnsTable;
import shary.recetas.activity.SQLite.UpdateRecords;

/**
 * Created by Shary on 29/06/2015.
 */
public class Main extends ActionBarActivity {
    private Toolbar toolbar;
    NavigationView navigationView;
    private DrawerLayout drawerLayout;
    int mNavItemId = 0;
    ColumnsTable columnas= new ColumnsTable();
    private UpdateRecords download;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        System.out.println("CONECTION "+ isConnected);
        if (isConnected==true)
        {
            download= new UpdateRecords(this,"recipe",columnas.getColumnsTableRecipe(),"recipes");
            download= new UpdateRecords(this,"ingredients",columnas.getColumnsTableIngredients(),"ingredients");
            download= new UpdateRecords(this,"step",columnas.getColumnsTableStep(),"instructions");
        }


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.menuico);
        ab.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.naview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int x = menuItem.getItemId();
                String title = menuItem.getTitle().toString();
                Fragment fragment = null;
                switch (x) {
                    case R.id.navigation_sub_item_1:
                        fragment = new HomeFragment();
                        title = getString(R.string.title_home);
                        Snackbar.make(findViewById(android.R.id.content), title, Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_sub_item_2:
                        fragment = new RecetasFragment();
                        title = getString(R.string.title_recetas);
                        Snackbar.make(findViewById(android.R.id.content), title, Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_sub_item_3:
                        fragment = new IngredientesFragment();
                        title = getString(R.string.title_ingredientes);
                        Snackbar.make(findViewById(android.R.id.content), title, Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_sub_item_4:
                        fragment = new FavoritosFragment();
                        title = getString(R.string.title_favoritos);
                        Snackbar.make(findViewById(android.R.id.content), title, Snackbar.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

                    // set the toolbar title
                    getSupportActionBar().setTitle(title);
                }

                Log.d("MENU ITEM", menuItem.getTitle().toString());
                drawerLayout.closeDrawers();
                return true;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
