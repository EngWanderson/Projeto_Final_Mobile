package br.com.academiafinal.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.com.academiafinal.entidades.Medidas;

public class BdMedidas extends BdHelper {
    Context context;
    public BdMedidas(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public  long insertarMedidas(String nome, String pescoco, String ombro, String peitoral, String abdome, String cintura, String quadril, String biceps, String antebraco, String coxa,
                                 String panturrilha, String biceps2, String antebraco2, String coxa2, String panturrilha2){
        long id = 0;
        try {
            BdHelper dbHelper = new BdHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nome", nome);
            values.put("pescoco", pescoco);
            values.put("ombro",ombro);
            values.put("peitoral",peitoral);
            values.put("abdome",abdome);
            values.put("cintura",cintura);
            values.put("quadril",quadril);
            values.put("biceps",biceps);
            values.put("antebraco",antebraco);
            values.put("coxa",coxa);
            values.put("panturrilha",panturrilha);
            values.put("biceps2",biceps2);
            values.put("antebraco2",antebraco2);
            values.put("coxa2",coxa2);
            values.put("panturrilha2",panturrilha2);
            id = db.insert(TABLE_MEDIDAS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Medidas> mostrarMedidas(){
        BdHelper dbHelper = new BdHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Medidas> listaMedidas = new ArrayList<>();
        Medidas medidas;
        Cursor cursorMedidas;

        cursorMedidas= db.rawQuery(" SELECT * FROM " + TABLE_MEDIDAS + " ORDER BY nome ASC",null);
       if (cursorMedidas.moveToFirst()){
           do {
               medidas = new Medidas();
               medidas.setId(cursorMedidas.getInt(0) );
               medidas.setNome(cursorMedidas.getString(1));
               listaMedidas.add(medidas);
           }while (cursorMedidas.moveToNext());
       }
        cursorMedidas.close();
       return listaMedidas;
    }

    public Medidas verMedidas(int id){
        BdHelper dbHelper = new BdHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Medidas medidas =null;
        Cursor cursorMedidas;
        cursorMedidas = db.rawQuery("SELECT * FROM " + TABLE_MEDIDAS + " WHERE id = " + id + " LIMIT 1", null);
        if (cursorMedidas.moveToNext()){
            medidas = new Medidas();
            medidas.setId(cursorMedidas.getInt(0));
            medidas.setNome(cursorMedidas.getString(1));
            medidas.setPescoco(cursorMedidas.getString(2));
            medidas.setOmbro(cursorMedidas.getString(3));
            medidas.setPeitoral(cursorMedidas.getString(4));
            medidas.setAbdome(cursorMedidas.getString(5));
            medidas.setCintura(cursorMedidas.getString(6));
            medidas.setQuadril(cursorMedidas.getString(7));
            medidas.setBiceps(cursorMedidas.getString(8));
            medidas.setAntebraco(cursorMedidas.getString(9));
            medidas.setCoxa(cursorMedidas.getString(10));
            medidas.setPanturrilha(cursorMedidas.getString(11));
            medidas.setBiceps2(cursorMedidas.getString(12));
            medidas.setAntebraco2(cursorMedidas.getString(13));
            medidas.setCoxa2(cursorMedidas.getString(14));
            medidas.setPanturrilha2(cursorMedidas.getString(15));

        }
        cursorMedidas.close();
        return medidas;
    }

    public boolean editarMedidas(int id, String nome, String pescoco, String ombro, String peitoral, String abdome,String cintura, String quadril, String biceps, String antebraco, String coxa,
                                 String panturrilha, String biceps2, String antebraco2, String coxa2, String panturrilha2 ){
        boolean correto = false;
        BdHelper dbHelper = new BdHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_MEDIDAS + " SET nome = '" + nome + "', pescoco = '" + pescoco + "', ombro = '" + ombro + "', peitoral = '" + peitoral +"', abdome = '" + abdome + "', cintura = '" + cintura + "', quadril = '" + quadril + "', biceps = '" + biceps + "', antebraco = '" + antebraco + "', coxa = '" + coxa + "', panturrilha = '" + panturrilha + "', biceps2 = '" + biceps2 + "', antebraco2 = '" + antebraco2 + "', coxa2 = '" + coxa2 + "', panturrilha2 = '" + panturrilha2 + "'  WHERE id='" + id + "' ");
            correto = true;
        } catch (Exception ex) {
            ex.toString();
            correto = false;
        } finally {
            db.close();
        }
        return correto;

    }
    public boolean eliminarMedidas(int id) {

        boolean correto = false;

        BdHelper dbHelper = new BdHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_MEDIDAS + " WHERE id = '" + id + "'");
            correto = true;
        } catch (Exception ex) {
            ex.toString();
            correto = false;
        } finally {
            db.close();
        }

        return correto;
    }

}
