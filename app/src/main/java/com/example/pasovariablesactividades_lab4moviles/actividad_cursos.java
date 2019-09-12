package com.example.pasovariablesactividades_lab4moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class actividad_cursos extends AppCompatActivity {


    ListView lista;
    String datosactividad01="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_cursos);










        lista =(ListView) findViewById(R.id.listadejuegos);

        /*
        Creación del array donde se guardarán
        los valores que se mostrarán en el
        listView:
         */
        String[] values=new String[]{
                "base de datos avanzadas",
                "base de datos",
                "programación orientada a objetos",
                "Diseño de interfaces",
                "algoritmos"

        };

        /*
        Creación del adaptador para mostrar Strings en
        el listview:
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                values
        );

        /*
        Se aplica el adaptador "adapter" al
        objeto java enlazado con la listview:
         */
        lista.setAdapter(adapter);


        /*
        Se crea un listener sobre el objeto java lista:
         */

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;

                /*
                Extrae el string seleccionado del listview y lo guarda
                en la variable itemValue:
                 */
                String itemValue = (String) lista.getItemAtPosition(position);

                /*
                Genera un intent nuevo que nos llevará del activity actual
                al MainActivity, a su vez envia por medio del método putExtra
                2 elementos, uno el valor seleccionado y el otro no estoy seguro que es:
                 */
                Intent intent = new Intent(actividad_cursos.this, MainActivity.class);
                intent.putExtra("parametro", itemValue);
                intent.putExtra("datosactividad01", datosactividad01);
                startActivity(intent);

            }
        });






        /*
        Crea una variable llamada "recibidos" del tipo Bundle,
        esto nos permitirá capturar los datos enviados entre intents;
         */
        Bundle recibidos = this.getIntent().getExtras();
        if(recibidos != null){
            datosactividad01 = getIntent().getExtras().getString("seleccionados");
        }
















    }
}
