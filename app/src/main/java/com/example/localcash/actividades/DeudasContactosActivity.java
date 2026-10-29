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

public class DeudasContactosActivity extends AppCompatActivity {

    private EditText etNombreContacto, etMontoDeuda;
    private Button btnGuardarContactoDeuda;
    private ConexionSQLite conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudas_contactos);

        etNombreContacto = findViewById(R.id.etNombreContacto);
        etMontoDeuda = findViewById(R.id.etMontoDeuda);
        btnGuardarContactoDeuda = findViewById(R.id.btnGuardarContactoDeuda);
        conexion = new ConexionSQLite(this);

        btnGuardarContactoDeuda.setOnClickListener(v -> guardarContactoYDeuda());
    }

    private void guardarContactoYDeuda() {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valContacto = new ContentValues();
        valContacto.put("nombre", etNombreContacto.getText().toString());
        long idContacto = db.insert("contactos", null, valContacto);

        String montoTexto = etMontoDeuda.getText().toString();
        if(montoTexto.isEmpty()) montoTexto = "0";

        if (idContacto != -1) {
            ContentValues valDeuda = new ContentValues();
            valDeuda.put("id_compra", 1);
            valDeuda.put("id_contacto", idContacto);
            valDeuda.put("monto_adeudado", Double.parseDouble(montoTexto));

            db.insert("deudas", null, valDeuda);
            Toast.makeText(this, "Contacto y deuda registrados", Toast.LENGTH_SHORT).show();

            etNombreContacto.setText("");
            etMontoDeuda.setText("");
        }
        db.close();
    }
}