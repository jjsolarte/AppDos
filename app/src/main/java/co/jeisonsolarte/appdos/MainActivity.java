package co.jeisonsolarte.appdos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtContr;
    Button btnAcceder, btnRegistro;

    String nombre,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarPreferencias();

        edtNombre = findViewById(R.id.mainEdtNombre);
        edtContr = findViewById(R.id.mainEdtContr);
        btnAcceder = findViewById(R.id.mainBtnAcceder);
        btnRegistro = findViewById(R.id.mainBtnRegistro);

        nombre = "Falcao";
        contraseña = "123";

        //Toast.makeText(this, "Listo el OnCreate", Toast.LENGTH_LONG).show();

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (edtNombre.getText().toString().equals(nombre) && edtContr.getText().toString().equals(contraseña)){
                    Toast.makeText(MainActivity.this, "Bienvenido "+nombre, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Opciones.class);
                    startActivity(i);

                }else {
                    Toast.makeText(MainActivity.this, "Verificar Datos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Registro.class);
                startActivity(intent);
            }
        });

    }

    private void verificarPreferencias() {
        SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        if (!pref.getString("nombre","sorry").equals("sorry")){
            Intent i = new Intent(this,Opciones.class);
            startActivity(i);
            finish();
        }

    }
}