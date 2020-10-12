package com.uniso.lpdm.lemonpepper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NovoProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_produto);
    }

    //Botão de salvar, ao ser clicado ele nos leva a activity Exibir Produto
    public void onClickSalvar(View view){
        Intent intent = new Intent(this, ExibirProdutoActivity.class);
        startActivity(intent);
    }
}
