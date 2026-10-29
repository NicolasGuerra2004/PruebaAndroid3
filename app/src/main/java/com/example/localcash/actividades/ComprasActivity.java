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

public class ComprasActivity extends AppCompatActivity {

    private EditText etDescripcionCompra, etMontoCompra, etFechaCompra;
    private Button btnGuardarCompra;
    private ConexionSQLite conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        etDescripcionCompra = findViewById(R.id.etDescripcionCompra);
        etMontoCompra = findViewById(R.id.etMontoCompra);
        etFechaCompra = findViewById(R.id.etFechaCompra);
        btnGuardarCompra = findViewById(R.id.btnGuardarCompra);
        conexion = new ConexionSQLite(this);

        btnGuardarCompra.setOnClickListener(v -> guardarCompra());
    }

    private void guardarCompra() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descripcion", etDescripcionCompra.getText().toString());

        String montoTexto = etMontoCompra.getText().toString();
        if(montoTexto.isEmpty()) montoTexto = "0";
        valores.put("monto", Double.parseDouble(montoTexto));
        valores.put("fecha", etFechaCompra.getText().toString());
        valores.put("es_programada", 1);

        long idResultante = db.insert("compras", null, valores);
        if (idResultante != -1) {
            Toast.makeText(this, "Compra registrada y agendada", Toast.LENGTH_SHORT).show();
            etDescripcionCompra.setText("");
            etMontoCompra.setText("");
            etFechaCompra.setText("");
        }
        db.close();
    }
}