package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1) Atributos
    EditText txtNome;
    CheckBox cbPericles, cbBlackSabbath,cbManuelGomes;
    Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' o layout com a programação
        txtNome = (EditText) findViewById(R.id.txtNome);
        cbBlackSabbath = (CheckBox) findViewById(R.id.cbBlackSabbath);
        cbManuelGomes = (CheckBox) findViewById(R.id.cbManuelGomes);
        cbPericles = (CheckBox) findViewById(R.id.cbPericles);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);

        //3) Evento do botao verificar
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperando valor do txtNome
                String nome = txtNome.getText().toString();

                //Varriável auxiliar
                String cantores = "";
                //Verificando itens selecionados
                if(cbPericles.isChecked())
                {
                    cantores +=  "Péricles \n";
                }
                if(cbBlackSabbath.isChecked())
                {
                    cantores += "Black Sabbath \n";
                }
                if (cbManuelGomes.isChecked())
                {
                    cantores += "Manuel Gomes";
                }

                //Mostrando os valores selecionados
                Toast.makeText(MainActivity.this,
                             "Olá: "+nome +
                                 "\n Meus Cantores Prediletos: \n"
                                 + cantores,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}