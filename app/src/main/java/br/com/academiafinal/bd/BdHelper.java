package br.com.academiafinal.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BdHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOME = "medida.db";
    public static final String TABLE_MEDIDAS = "t_medidas";

    public BdHelper(@Nullable Context context){
        super(context, DATABASE_NOME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MEDIDAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "pescoco TEXT NOT NULL," +
                "ombro TEXT    NOT NULL," +
                "peitoral TEXT NOT NULL," +
                "abdome TEXT NOT NULL," +
                "cintura TEXT NOT NULL," +
                "quadril TEXT NOT NULL," +
                "biceps TEXT NOT NULL," +
                "antebraco TEXT NOT NULL," +
                "coxa TEXT NOT NULL," +
                "panturrilha TEXT NOT NULL," +
                "biceps2 TEXT NOT NULL," +
                "antebraco2 TEXT NOT NULL," +
                "coxa2 TEXT NOT NULL," +
                "panturrilha2 TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MEDIDAS);
        onCreate(sqLiteDatabase);
    }
}
