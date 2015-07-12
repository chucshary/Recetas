package shary.recetas.activity.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shary on 17/03/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "recipes.db";

    private static final String TABLE_RECIPE = "recipe";
    private static final String RECIPE_ID = "id";
    private static final String RECIPE_NOMBRE = "nombre";
    private static final String RECIPE_CATEGORIA = "categoria";
    private static final String RECIPE_FAVORITO = "favorito";
    private static final String RECIPE_TIPO = "tipo";

    private static final String TABLE_INGREDIENTS = "ingredients";
    private static final String INGREDIENTS_ID = "id";
    private static final String INGREDIENTS_NOMBRE = "nombre";

    private static final String TABLE_RECIPE_INGREDIENTS = "recipe_ingredients";
    private static final String RECIPE_INGREDIENTS_ID = "id";
    private static final String RECIPE_INGREDIENTS_IDR = "id_receta";
    private static final String RECIPE_INGREDIENTS_IDI = "id_ingrediente";
    private static final String RECIPE_INGREDIENTS_CANTIDAD = "cantidad";

    private static final String TABLE_STEP = "step";
    private static final String STEP_ID = "id";
    private static final String STEP_ID_RECETA = "id_receta_step";
    private static final String STEP_PASO = "paso";
    private static final String STEP_DESCRIPCION = "paso_descripcion";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_RECIPE_TABLE = "CREATE TABLE " + TABLE_RECIPE + "("
                + RECIPE_ID + " INTEGER PRIMARY KEY," + RECIPE_NOMBRE + " TEXT,"
                + RECIPE_CATEGORIA + " TEXT," + RECIPE_FAVORITO + " INTEGER,"
                + RECIPE_TIPO + " TEXT" + ")";

        String CREATE_INGREDIENTS_TABLE = "CREATE TABLE " + TABLE_INGREDIENTS + "("
                + INGREDIENTS_ID + " INTEGER PRIMARY KEY," + INGREDIENTS_NOMBRE + " TEXT" + ")";

        String CREATE_RECIPE_INGREDIENTS_TABLE = "CREATE TABLE " + TABLE_RECIPE_INGREDIENTS + "("
                + RECIPE_INGREDIENTS_ID + " INTEGER PRIMARY KEY," + RECIPE_INGREDIENTS_IDR + " INTEGER,"
                + RECIPE_INGREDIENTS_IDI + " INTEGER,"
                + RECIPE_INGREDIENTS_CANTIDAD + " TEXT" + ")";

        String CREATE_STEP_TABLE = "CREATE TABLE " + TABLE_STEP + "("
                + STEP_ID + " INTEGER PRIMARY KEY," + STEP_ID_RECETA + " INTEGER,"
                + STEP_PASO + " INTEGER,"
                + STEP_DESCRIPCION + " TEXT" + ")";


        db.execSQL(CREATE_RECIPE_TABLE);
        db.execSQL(CREATE_INGREDIENTS_TABLE);
        db.execSQL(CREATE_RECIPE_INGREDIENTS_TABLE);
        db.execSQL(CREATE_STEP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_INGREDIENTS);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STEP);
        onCreate(db);

    }
}
