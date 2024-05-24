package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    // 1) Atributos
    Button btnAc1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Iniciando' elementos da tela
        btnAc1 = (Button) findViewById(R.id.btnCalcular);


        // 3) Evento do botão
        btnAc1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Programa-se aqui!!!!
                // Classe Intent
                //Responsável por iniciar outras activities
                //assim como passar parâmetros ou não para as mesmas
                Intent it = new Intent(MainActivity.this,
                                                   Tela2.class);
                //Iniciando o Intent
                startActivity(it);
            }
        });//btnAc1
    }//onCreate()
}//MainActivity