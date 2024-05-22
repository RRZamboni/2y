package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1) Atributos
    EditText nominho;
    SeekBar barrinha;
    Button botaozinho;
    TextView numerinho;
    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        nominho = (EditText) findViewById(R.id.txtNome);
        barrinha = (SeekBar) findViewById(R.id.seekBar);
        botaozinho = (Button)  findViewById(R.id.btnTestar);
        numerinho = (TextView) findViewById(R.id.txtNumero);



        //Evento da barrinha (SeekBar)
        barrinha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Metodo altera o parâmetro do 'progress' conforme a barra
                //é movimentada
                aux = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                numerinho.setText("Valor:"+aux);
            }
        });

        //Evento do botao
        botaozinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperando o valor do editText
                String nomeUser = nominho.getText().toString();

                //Mostrando Mens. para o usuário
                Toast.makeText(MainActivity.this,
                                "Nome:"+nomeUser + "\n"
                                    +"Idade:"+aux,
                                Toast.LENGTH_LONG).show();
            }
        });


    }
}