package co.jeisonsolarte.appdos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.jeisonsolarte.appdos.Adapters.AdapterOpciones;
import co.jeisonsolarte.appdos.modelo.ItemModel;

public class Opciones extends AppCompatActivity {

    List<ItemModel> listaDatos;
    AdapterOpciones adapterOpciones;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        listaDatos = new ArrayList<>();
        llenarListaDatos();
        recyclerView = findViewById(R.id.opcRecicler);
        adapterOpciones = new AdapterOpciones((ArrayList<ItemModel>) listaDatos,R.layout.item_opc,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterOpciones); //como implementamos a la lista (Recycler) nuestro adaptador
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterOpciones.notifyDataSetChanged(); //se actualiza el adaptador

        SharedPreferences pref = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        Toast.makeText(this, "Bienvenido "+pref.getString("nombre","Señor")
                , Toast.LENGTH_SHORT).show();

    }

    private void llenarListaDatos() {
        listaDatos.add(new ItemModel("Jara","Cancante de Rancheras",32,"https://e-cdns-images.dzcdn.net/images/artist/cae0a2970d337ecb66be01f00cc0254e/200x200-000000-80-0-0.jpg"));
        listaDatos.add(new ItemModel("Happy","Rodando Feliz",24,"https://images.lifealth.com/uploads/2018/03/commitments-to-make-if-you-want-to-be-happy.jpg"));
        listaDatos.add(new ItemModel("Android","OS libre",18,"https://images.clarin.com/2018/10/15/WVULjOspp_1256x620__1.jpg"));
    }

}
