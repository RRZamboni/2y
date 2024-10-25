package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Atributos
    Button btnSalvar;
    EditText txtNome,txtCurso;
    ListView lista;

    ArrayList<String> listaL = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciando elementos
        lista = (ListView) findViewById(R.id.lista);
        txtCurso = (EditText) findViewById(R.id.txtCurso);
        txtNome = (EditText) findViewById(R.id.txtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        //Evento do Botao
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel
                String nome = txtNome.getText().toString();
                String curso = txtCurso.getText().toString();

                //Validando os campos
                if(!nome.isEmpty() || !curso.isEmpty())
                {
                    //Adicionando na lista
                    listaL.add("Nome: " + nome + " Curso:" + curso);

                    //Adaptando a lista
                    ArrayAdapter<String> listaAdaptada = new
                            ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            listaL);

                    //Inserindo no Layout
                    lista.setAdapter(listaAdaptada);
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Insira um valor válido, CAGALHÃO!",
                            Toast.LENGTH_LONG).show();
                }

                //Limpando os campos
                txtCurso.setText("");
                txtNome.setText("");
            }
        });// botao

        //Método da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int posicao, long l)
            {
                //Mostrar mensagem
                Toast.makeText(MainActivity.this,
                                "Selecionado"+ listaL.get(posicao),
                                Toast.LENGTH_LONG).show();

            }
        });//lista

        //Deletar Item
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {   @Override
            public boolean onItemLongClick(AdapterView<?> adapterView,
                                        View view, int posicao, long l)
            {
                //Deletando o item selecionado do ArrayList<>
                listaL.remove(posicao);

                //Adaptando a lista
                ArrayAdapter<String> listaAdaptada = new
                        ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        listaL);

                //Inserindo no Layout
                lista.setAdapter(listaAdaptada);

                return false;
            }
        });
    }//onCreate
}