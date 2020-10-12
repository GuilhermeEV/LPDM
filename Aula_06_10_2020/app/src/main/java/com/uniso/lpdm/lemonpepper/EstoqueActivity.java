package com.uniso.lpdm.lemonpepper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EstoqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);
    }

    //Botão de cadastrar um email para o fornecedor solicitando um pedido.
    public void onClickCadastrarEmail(View view){
        Intent intent = new Intent(this, CriarEmailActivity.class);
        startActivity(intent);
    }

    //Botão de novo produto onde ao ser clicado é levado a tela de novo produto
    public void onClickNovoProduto(View view){
        Intent intent = new Intent(this, NovoProdutoActivity.class);
        startActivity(intent);
    }
}
