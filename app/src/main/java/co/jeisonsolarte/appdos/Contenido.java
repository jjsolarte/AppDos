package co.jeisonsolarte.appdos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Contenido extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);

        imageView = findViewById(R.id.contImg);

        Picasso.get()
                .load("https://i.kinja-img.com/gawker-media/image/upload/s--PYNU2iF9--/c_scale,f_auto,fl_progressive,q_80,w_800/fg3mrf4aan5ivxa6z4hz.jpg")
                .into(imageView);
    }
}
