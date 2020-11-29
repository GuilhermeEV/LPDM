package com.uniso.lpdm.lemonpepper;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.TextView;

        import java.util.Locale;

public class CronometroActivity extends AppCompatActivity {

    private int segundos = 0;
    private boolean executando;
    private boolean estavaExecutando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        executando = true;
        estavaExecutando = true;

        //Verificação para ver se atividade já estava rodando
        if(savedInstanceState != null){
            segundos = savedInstanceState.getInt("segundos");
            executando = savedInstanceState.getBoolean("executando");
            estavaExecutando = savedInstanceState.getBoolean("estavaExecutando");
        }
        executarTemporizador(); //Logo ao abrir essa atividade, o cronometro terá início
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // O bundle representa o estado atual da atividade antes de ser destruida (no caso de zerar ou parar o cronometro)
        savedInstanceState.putInt("segundos", segundos);
        savedInstanceState.putBoolean("executando", executando);
        savedInstanceState.putBoolean("estavaExecutando", estavaExecutando);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume(){
        super.onResume();
        executando = estavaExecutando;
    }

    public void onClickIniciar(View view){
        executando = true;
    }

    public void onClickParar (View view){
        executando = false;
    }

    public void onClickZerar(View view){
        executando = false;
        segundos = 0;
    }

    private void executarTemporizador(){
        final TextView textView = (TextView) findViewById(R.id.txtTempo); //a variável necessita ser final para poder ser acessada dentro do handler
        final Handler handler = new Handler(); // o handler é uma classe android que agenda a execução de determinado código no futuro

            handler.post(new Runnable() {
                @Override
                public void run() {
                    // Calculo em quantos segundos passaram
                    int horas = segundos / 3600;
                    int minutos = (segundos % 3600) / 60;
                    int segundos_interno = segundos % 60;

                    //Formatação dos valores inteiros usando o String.format, que será exibido no text view
                    String time = String.format(Locale.getDefault(), "%d:%02d:%02d", horas, minutos, segundos_interno);
                    textView.setText(time);
                    if (executando) {
                        segundos++;
                    }
                    handler.postDelayed(this, 1000);
                }
            }
        );
    }

    //Volta para a Activity (tela) principal, no caso a main, ou seja, a tela inicial do aplicativo
    public void mudarTela(View view){
        Intent intent = new Intent(this, LemonPepperActivity.class);
        startActivity(intent);
    }
}