package com.uniso.lpdm.lemonpepper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CriarEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_email);
    }

    public void onClickEnviar(View view){
        //Pega o texto da tela
        EditText edtProduto = (EditText) findViewById(R.id.edtProduto);
        EditText edtQtd = (EditText) findViewById(R.id.edtQtd);

        //Pega a "quantidade" da tela
        String produto = edtProduto.getText().toString();
        String qtd = edtQtd.getText().toString();

        String msgFornecedor = "SOLICITAÇÃO DE PEDIDO \nProduto: " + produto + "\nQuantidade: " + qtd;

        Intent intent = new Intent(Intent.ACTION_SEND); //activity para compartilhamento externo
        intent.setType("text/plain"); //ajuste do tipo da mensagem que vai ser enviada
        intent.putExtra(Intent.EXTRA_TEXT, msgFornecedor); //adiciona a mensagem do usuário como parâmetro
        intent.putExtra(Intent.EXTRA_SUBJECT, "Fornecedor"); //adiciona a mensagem de exibição do usuário

        Intent shareIntent = Intent.createChooser(intent, null);

        startActivity(shareIntent);

    }
}
