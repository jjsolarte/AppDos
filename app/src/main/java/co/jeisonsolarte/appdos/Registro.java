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

import co.jeisonsolarte.appdos.modelo.Usuario;

public class Registro extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtCorreo, edtTelefono, edtContra, edtContr2;
    Button btnGuardar;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializarViews();
    }

    private void inicializarViews() {
        edtNombre = findViewById(R.id.regEdtNombre);
        edtApellido = findViewById(R.id.regEdtApellido);
        edtCorreo = findViewById(R.id.regEdtCorreo);
        edtTelefono = findViewById(R.id.regEdtTelefono);
        edtContra = findViewById(R.id.regEdtContra);
        edtContr2 = findViewById(R.id.regEdtContra2);

        btnGuardar = findViewById(R.id.regBtnGuardar);

        usuario = new Usuario();
    }

    public void onGuardarUser(View view){

        usuario.setNombre(edtNombre.getText().toString());
        usuario.setApellido(edtApellido.getText().toString());
        usuario.setTelefono(Integer.parseInt(edtTelefono.getText().toString()));
        usuario.setCorreo(edtCorreo.getText().toString());
        usuario.setContra(edtContra.getText().toString());
        usuario.setContra2(edtContr2.getText().toString());

        Toast.makeText(this, "Usuario: "+usuario.getNombre()+" registro "+usuario.getCorreo(), Toast.LENGTH_SHORT).show();

        SharedPreferences pref = getSharedPreferences
                ("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = pref.edit();
        edit.putString("nombre",""+edtNombre.getText().toString());
        edit.commit();

        Intent intent = new Intent(this,Opciones.class);
        startActivity(intent);

    }

}
