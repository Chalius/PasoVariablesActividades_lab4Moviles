package com.example.pasovariablesactividades_lab4moviles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actividad_cerrar extends AppCompatActivity {

    Button btn_cerrar, btn_atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_cerrar);


        btn_atras = findViewById(R.id.btn_atras);
        btn_cerrar = findViewById(R.id.btn_cerrar);


        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Nos lleva a la actividad principal y mata la actividad actual.
                 */
                Intent i = new Intent(actividad_cerrar.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                actividad_cerrar.this.finish();
                startActivity(i);


            }
        });


        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(actividad_cerrar.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Desea salir de la aplicación ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cerrar();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                dialogo1.show();
            }
        });

















    }
    protected void cerrar(){

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    protected void cancelar(){

    }


}
