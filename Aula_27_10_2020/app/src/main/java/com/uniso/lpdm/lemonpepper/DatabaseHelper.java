package com.uniso.lpdm.lemonpepper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "lemonpepper";
    private static final int DB_VERSION = 2;

    DatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        atualizarBanco(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        atualizarBanco(db, oldVersion, newVersion);
    }

    public static void insertBebida(SQLiteDatabase db, String nome, String descricao, double preco_unitario, int imagem_resource_id){

        ContentValues bebida = new ContentValues();
        bebida.put("nome", nome);
        bebida.put("descricao", descricao);
        bebida.put("preco_unitario", preco_unitario);
        bebida.put("imagem_resource_id", imagem_resource_id);
        db.insert("BEBIDA", null, bebida);
    }

    private void atualizarBanco(SQLiteDatabase db, int oldVersion, int newVersion){
        String sql;
        if(oldVersion < 1){

            sql = "CREATE TABLE BEBIDA (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, " +
                    "descricao TEXT, " +
                    "preco_unitario REAL," +
                    "imagem_resource_id INTEGER" +
                    ");";

            db.execSQL(sql);

            insertBebida(db, "CocaCola", "Uma Coca-Cola", 5.00, R.drawable.coca);
            insertBebida(db, "Guarana", "Um Guaraná", 4.00, R.drawable.guarana);
            insertBebida(db, "Fanta", "Uma Fanta Laranja", 4.00, R.drawable.fanta);
        }

        if (oldVersion <= 2){
            sql = "ALTER TABLE BEBIDA ADD COLUMN favorita NUMERIC;";
            db.execSQL(sql);
        }

    }
}
