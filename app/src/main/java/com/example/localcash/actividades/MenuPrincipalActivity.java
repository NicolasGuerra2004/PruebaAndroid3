package com.example.localcash.actividades;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localcash.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        findViewById(R.id.btnCuentas).setOnClickListener(v ->
                startActivity(new Intent(MenuPrincipalActivity.this, CuentasActivity.class)));

        findViewById(R.id.btnMapa).setOnClickListener(v ->
                startActivity(new Intent(MenuPrincipalActivity.this, MapaActivity.class)));

        findViewById(R.id.btnCompras).setOnClickListener(v ->
                startActivity(new Intent(MenuPrincipalActivity.this, ComprasActivity.class)));

        findViewById(R.id.btnDeudas).setOnClickListener(v ->
                startActivity(new Intent(MenuPrincipalActivity.this, DeudasContactosActivity.class)));
    }
}