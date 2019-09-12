package com.example.pasovariablesactividades_lab4moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    EditText txtseleccionados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Enlaza los objetos java a los elementos del xml:
         */
        txtseleccionados=(EditText) findViewById(R.id.txtseleccionados);
        //txtseleccionados.setEnabled(false);
        txtseleccionados.setFocusable(true);

        lista=(ListView)findViewById(R.id.lista);

        /*
        Crea un array "values" que contendrá la información
        que se motrará en el listview:
         */
        String[] values=new String[]{
                "Juegos",
                "Aplicaciones",
                "Cursos",
                "Profesores",
                "Cerrar",
        };

        /*
        Crea el adaptador para poblar el listview con Strings:
         */
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,
                values);

        /*
        Aplica el adaptador en el listview de nombre "lista":
         */
        lista.setAdapter(adapter);


        /*
        Se aplica un listener el objeto java "lista":
         */
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) lista.getItemAtPosition(position);
                /*
                Toast.makeText(
                        getApplicationContext(),
                        "Posición: "+itemPosition+" Descripcion : "+itemValue,
                        Toast.LENGTH_LONG).show();
                */

                /*
                Se captura los elementos que tiene el elemento xml de id:"txtseleccionados",
                se crea un nuevo intent que nos llevará a actividad_juegos y le pasa
                la información de "txtseleccionados":
                 */
                String seleccionados = txtseleccionados.getText().toString();
                Intent intent;
                switch (itemPosition) {
                    case 0:
                        intent = new Intent(MainActivity.this, actividad_juegos.class);
                        intent.putExtra("seleccionados",seleccionados);
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, actividad_aplicaciones.class);
                        intent.putExtra("seleccionados",seleccionados);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, actividad_cursos.class);
                        intent.putExtra("seleccionados",seleccionados);
                        break;

                    case 3:
                        intent = new Intent(MainActivity.this, actividad_profesores.class);
                        intent.putExtra("seleccionados",seleccionados);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, actividad_cerrar.class);
                        intent.putExtra("seleccionados",seleccionados);
                        break;

                    default:
                        intent = new Intent(MainActivity.this, actividad_aplicaciones.class);
                        intent.putExtra("seleccionados",seleccionados);


                }


                startActivity(intent);
            }
        });



        /*
        Captura los datos enviados desde otro intent:
         */
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String recibidos = getIntent().getExtras().getString("parametro");
            String datosactividad01 = getIntent().getExtras().getString("datosactividad01");



            txtseleccionados.setText(datosactividad01 + recibidos + "\n");

        }

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }


    }
}
