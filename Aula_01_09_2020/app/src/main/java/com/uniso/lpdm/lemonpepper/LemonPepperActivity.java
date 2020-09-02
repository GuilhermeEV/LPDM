package com.uniso.lpdm.lemonpepper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LemonPepperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemon_pepper);
    }

    public void onClickRegistrarPedido (View view){
        TextView registrarPedido = (TextView) findViewById(R.id.pedido);
        registrarPedido.setText("Registrando Pedido...");
    }

    public void onClickTotalHoras (View view){
        TextView totalHoras = (TextView) findViewById(R.id.horas);
        totalHoras.setText("Total de Horas");
    }

}