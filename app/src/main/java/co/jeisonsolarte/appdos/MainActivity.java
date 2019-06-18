package co.jeisonsolarte.appdos;

import android.content.Intent;
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

}