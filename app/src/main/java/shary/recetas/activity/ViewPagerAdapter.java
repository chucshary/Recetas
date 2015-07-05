package shary.recetas.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import shary.recetas.activity.ingredients.Tab_1;
import shary.recetas.activity.ingredients.Tab_2;
import shary.recetas.activity.ingredients.Tab_3;
import shary.recetas.activity.ingredients.Tab_4;
import shary.recetas.activity.ingredients.Tab_Busqueda;
import shary.recetas.activity.recipes.Tab_Recipes;

/**
 * Created by Shary on 04/07/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT;
    private String[] tabTitles;
    private View context;
    private int positionNav;

    public ViewPagerAdapter(FragmentManager fm, View context, String[] titles, int position, int page) {
        super(fm);
        this.context = context;
        this.tabTitles = titles;
        this.positionNav = position;
        this.PAGE_COUNT = page;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (positionNav == 0) {
            Tab_Recipes tab_Recipes;
            switch (position) {
                case 0:
                     tab_Recipes = new Tab_Recipes();
                    return tab_Recipes;
                case 1:
                     tab_Recipes = new Tab_Recipes();
                    return tab_Recipes;
                case 2:
                     tab_Recipes = new Tab_Recipes();
                    return tab_Recipes;
                case 3:
                     tab_Recipes = new Tab_Recipes();
                    return tab_Recipes;
                case 4:
                     tab_Recipes = new Tab_Recipes();
                    return tab_Recipes;
            }
        } else {
            switch (position) {
                case 0:
                    Tab_1 tab_1 = new Tab_1();
                    return tab_1;
                case 1:
                    Tab_2 tab_2 = new Tab_2();
                    return tab_2;
                case 2:
                    Tab_3 tab_3 = new Tab_3();
                    return tab_3;
                case 3:
                    Tab_4 tab_4 = new Tab_4();
                    return tab_4;
                case 4:
                    Tab_Busqueda tab_busqueda = new Tab_Busqueda();
                    return tab_busqueda;
            }
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}