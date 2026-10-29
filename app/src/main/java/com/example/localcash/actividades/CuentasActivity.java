package com.example.localcash.actividades;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localcash.R;
import com.example.localcash.bd.ConexionSQLite;

public class CuentasActivity extends AppCompatActivity {

    private EditText etNombreCuenta, etSaldo;
    private Button btnGuardarCuenta;
    private ConexionSQLite conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        etNombreCuenta = findViewById(R.id.etNombreCuenta);
        etSaldo = findViewById(R.id.etSaldo);
        btnGuardarCuenta = findViewById(R.id.btnGuardarCuenta);
        conexion = new ConexionSQLite(this);

        btnGuardarCuenta.setOnClickListener(v -> guardarCuenta());
    }

    private void guardarCuenta() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", etNombreCuenta.getText().toString());

        String saldoTexto = etSaldo.getText().toString();
        if(saldoTexto.isEmpty()) saldoTexto = "0";
        valores.put("saldo", Double.parseDouble(saldoTexto));

        long idResultante = db.insert("cuentas", null, valores);
        if (idResultante != -1) {
            Toast.makeText(this, "Cuenta guardada", Toast.LENGTH_SHORT).show();
            etNombreCuenta.setText("");
            etSaldo.setText("");
        }
        db.close();
    }
}