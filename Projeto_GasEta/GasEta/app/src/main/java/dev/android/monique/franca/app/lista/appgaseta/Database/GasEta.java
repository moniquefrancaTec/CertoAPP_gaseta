package dev.android.monique.franca.app.lista.appgaseta.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEta extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION =1;

    Cursor cursor;
    SQLiteDatabase db;


    public GasEta(Context context) {
        super(context,DB_NAME,null,DB_VERSION);

        db=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel
                = "CREATE TABLE Combustive (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "precoGasolina REAL," +
                "precoEtanol REAL, " +
                "resultado TEXT)";

        db.execSQL(sqlTabelaCombustivel);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null,dados);

    }

    //TODO: criar métodos para implementar um Crud
}
