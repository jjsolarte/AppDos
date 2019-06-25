package co.jeisonsolarte.appdos.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.jeisonsolarte.appdos.R;
import co.jeisonsolarte.appdos.modelo.ItemModel;


public class AdapterOpciones extends RecyclerView.Adapter<AdapterOpciones.AdapterViewHolder>{

    /*  1. Creación de Parámetros a Recibir
        2. Creación del Constructor
        3. Creación de la clase AdapterViewHolder de Optimización
        4. Recordar añadir implementation 'com.android.support:recyclerview-v7:28.0.0'
        5. Extender de la clase ReciclerView.Adapter<Adapter.AdapterViewHolder>
     */

    private List<ItemModel> listaDatos;    //lista de obj a utilizar
    private int resource;                   //Layout que modela la info
    private Activity context;               //Donde se implementa el Adapter

    public AdapterOpciones(ArrayList<ItemModel> listaDatos, int resource, Activity context) {
        this.listaDatos = listaDatos;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override       //Método que infla el recurso xml
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(resource,viewGroup,false);
        return new AdapterViewHolder(view);
    }

    @Override       //Le pasamos a los view por medio del adapterviewholder la info de la lista
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {
        ItemModel itemModel = listaDatos.get(i);
        Picasso.get().load(itemModel.getImg()).into(adapterViewHolder.imagen);
        adapterViewHolder.nombre.setText(itemModel.getNombre());
        adapterViewHolder.descrip.setText(itemModel.getDescripcion());
        adapterViewHolder.edad.setText(""+itemModel.getEdad());
    }

    @Override       //Definimos cuantas veces debe hacer el proceso
    public int getItemCount() {
        return listaDatos.size();
    }

    //Aqui definimos la organización de nuestra información
    //implementamos el método constructor
    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView nombre;
        TextView descrip;
        TextView edad;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //pasamos cada view a los views definidos en la vista item xml
            imagen = itemView.findViewById(R.id.itemImg);
            nombre = itemView.findViewById(R.id.itemTitulo);
            descrip = itemView.findViewById(R.id.itemDescrip);
            edad = itemView.findViewById(R.id.itemEdad);
        }
    }


}
