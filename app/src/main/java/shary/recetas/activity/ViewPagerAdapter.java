package shary.recetas.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import shary.recetas.activity.ingredients.Tab_1;
import shary.recetas.activity.ingredients.Tab_2;
import shary.recetas.activity.ingredients.Tab_3;
import shary.recetas.activity.ingredients.Tab_4;
import shary.recetas.activity.ingredients.Tab_5;
import shary.recetas.activity.ingredients.Tab_6;
import shary.recetas.activity.ingredients.Tab_Busqueda;
import shary.recetas.activity.ingredients.Tab_Other_Ingredient;
import shary.recetas.activity.ingredients.Tab_Otros;
import shary.recetas.activity.recipes.Tab_Recipes;
import shary.recetas.activity.step.Tab_1_Step;
import shary.recetas.activity.step.Tab_2_Step;

/**
 * Created by Shary on 04/07/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT;
    private String[] tabTitles;
    private View context;
    private int positionNav = 0;
    public Tab_Recipes tab_Recipes;

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
        System.out.println("POSICION VIEW RECIPE " + position);
        if (positionNav == 0) {
            switch (position) {
                case 0:
                    tab_Recipes = Tab_Recipes.newInstance(0);
                    return tab_Recipes;
                case 1:
                    tab_Recipes = Tab_Recipes.newInstance(1);
                    return tab_Recipes;
                case 2:
                    tab_Recipes = Tab_Recipes.newInstance(2);
                    return tab_Recipes;
                case 3:
                    tab_Recipes = Tab_Recipes.newInstance(3);
                    return tab_Recipes;
                case 4:
                    tab_Recipes = Tab_Recipes.newInstance(4);
                    return tab_Recipes;
                default:
                    break;
            }
        } else if (positionNav == 1) {
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
                    Tab_5 tab_5 = new Tab_5();
                    return tab_5;
                case 5:
                    Tab_6 tab_6 = new Tab_6();
                    return tab_6;
                case 6:
                    Tab_Otros tab_otros = new Tab_Otros();
                    return tab_otros;
                case 7:
                    Tab_Other_Ingredient tab_other_ingredient = new Tab_Other_Ingredient();
                    return tab_other_ingredient;
                case 8:
                    Tab_Busqueda tab_busqueda = new Tab_Busqueda();
                    return tab_busqueda;
                default:
                    break;
            }
        } else {
            switch (position) {
                case 0:
                    Tab_1_Step tab_1_step = new Tab_1_Step();
                    return tab_1_step;
                case 1:
                    Tab_2_Step tab_2_step = new Tab_2_Step();
                    return tab_2_step;
                default:
                    break;
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