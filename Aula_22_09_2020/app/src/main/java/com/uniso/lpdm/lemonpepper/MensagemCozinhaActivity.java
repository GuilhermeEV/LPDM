package com.uniso.lpdm.lemonpepper;

/*Importações*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MensagemCozinhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_cozinha);
        }

        /*Botão de Enviar a Mensagem para o Whatsapp (compartilhar), onde a mesma cria um intent que pega a mensagem e converte para string*/
    public void onEnviarMensagemWhatsapp(View view){
        EditText editText = (EditText) findViewById(R.id.editMensagem);
        String mensagem = editText.getText().toString();

        Intent intencao = new Intent(Intent.ACTION_SEND); //activity para compartilhamento externo
        intencao.setType("text/plain");
        intencao.putExtra(Intent.EXTRA_TEXT, mensagem); //adiciona a mensagem do usuário como parâmetro
        intencao.putExtra(Intent.EXTRA_SUBJECT, "Assunto"); //adiciona a mensagem de exibição do usuário

        startActivity(intencao);
    }
}