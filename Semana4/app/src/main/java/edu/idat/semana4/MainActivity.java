package edu.idat.semana4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgProducto = findViewById(R.id.imgMiniatura);
        imgProducto.setImageResource(R.drawable.iphone);
    }
}