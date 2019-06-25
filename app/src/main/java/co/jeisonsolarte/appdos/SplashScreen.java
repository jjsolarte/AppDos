package co.jeisonsolarte.appdos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {

    ImageView imgSplash;
    private String imgUrl = "https://fsmedia.imgix.net/2c/2d/67/d8/9622/476b/ac24/cb01ac549f05.jpeg?rect=123%2C0%2C1194%2C597&auto=format%2Ccompress&dpr=2&w=650";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imgSplash = findViewById(R.id.splashImg);
        Picasso.get().load(imgUrl).into(imgSplash);

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();
    }
}
