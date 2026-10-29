package com.example.localcash.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLite extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "localcash.db";
    private static final int VERSION_BD = 1;

    public ConexionSQLite(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");

        db.execSQL("CREATE TABLE cuentas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, saldo REAL)");

        db.execSQL("CREATE TABLE movimientos (id INTEGER PRIMARY KEY AUTOINCREMENT, id_cuenta INTEGER, tipo TEXT, monto REAL, latitud REAL, longitud REAL)");

        db.execSQL("CREATE TABLE compras (id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT, monto REAL, fecha TEXT, es_programada INTEGER)");

        db.execSQL("CREATE TABLE deudas (id INTEGER PRIMARY KEY AUTOINCREMENT, id_compra INTEGER, id_contacto INTEGER, monto_adeudado REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS deudas");
        db.execSQL("DROP TABLE IF EXISTS compras");
        db.execSQL("DROP TABLE IF EXISTS movimientos");
        db.execSQL("DROP TABLE IF EXISTS cuentas");
        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);
    }
}