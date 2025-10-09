package com.example.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int scorePlayer = 0;
    private int scoreApp = 0;

    private TextView txtPlacar, txtResultado;
    private ImageView imgApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPlacar = findViewById(R.id.txtPlacar);
        txtResultado = findViewById(R.id.txtResultado);
        imgApp = findViewById(R.id.imgApp);
    }

    public void jogarPedra(View view) {
        jogar("pedra");
    }

    public void jogarPapel(View view) {
        jogar("papel");
    }

    public void jogarTesoura(View view) {
        jogar("tesoura");
    }

    private void jogar(String escolhaJogador) {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[new Random().nextInt(opcoes.length)];

        switch (escolhaApp) {
            case "pedra": imgApp.setImageResource(R.drawable.pedra); break;
            case "papel": imgApp.setImageResource(R.drawable.papel); break;
            case "tesoura": imgApp.setImageResource(R.drawable.tesoura); break;
        }

        String resultado;
        if (escolhaJogador.equals(escolhaApp)) {
            resultado = "EMPATE! :|";
        } else if (
                (escolhaJogador.equals("pedra") && escolhaApp.equals("tesoura")) ||
                        (escolhaJogador.equals("papel") && escolhaApp.equals("pedra")) ||
                        (escolhaJogador.equals("tesoura") && escolhaApp.equals("papel"))
        ) {
            resultado = "VOCÊ GANHOU! ;D";
            scorePlayer++;
        } else {
            resultado = "VOCÊ PERDEU... :(";
            scoreApp++;
        }

        txtResultado.setText("Resultado: " + resultado);
        atualizarPlacar();
    }

    private void atualizarPlacar() {
        txtPlacar.setText("Jogador: " + scorePlayer + " - App: " + scoreApp);
    }

    public void reiniciar(View view) {
        scorePlayer = 0;
        scoreApp = 0;
        atualizarPlacar();
        txtResultado.setText("Resultado: ");
        imgApp.setImageResource(R.drawable.padrao);
    }
}