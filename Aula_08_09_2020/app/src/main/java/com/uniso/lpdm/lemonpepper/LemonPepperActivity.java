package com.uniso.lpdm.lemonpepper;

/*Importações*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LemonPepperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemon_pepper);
    }

    /*Botão que ao ser clicado exibe o texto "Registrando Pedido..." */
    public void onClickRegistrarPedido (View view){
        TextView registrarPedido = (TextView) findViewById(R.id.pedido);
        registrarPedido.setText("Registrando Pedido...");
    }

    /*Botão que ao ser clicado exibe uma mensagem sobre o Total de Horas */
    public void onClickTotalHoras (View view){
        TextView totalHoras = (TextView) findViewById(R.id.horas);
        totalHoras.setText("Total de Horas");
    }

    /*Botão que ao ser clicado abre uma nova atividade através de uma intent */
    public void onEnviarMensagemCozinha (View view){

        Intent intencao = new Intent(this, MensagemCozinhaActivity.class);

        startActivity(intencao);
    }

}