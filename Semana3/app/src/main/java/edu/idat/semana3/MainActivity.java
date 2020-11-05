package edu.idat.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtOpSumaA, edtOpSumaB;
    private Button btnSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btnLanzarActividad = findViewById(R.id.btnLanzarActividad);
//
//        btnLanzarActividad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                intent.putExtra("nombre", "Anónimo");
//                startActivity(intent);
//            }
//        });

        edtOpSumaA = findViewById(R.id.edtOpSumaA);
        edtOpSumaB = findViewById(R.id.edtOpSumaB);
        btnSumar = findViewById(R.id.btnSumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                int numeroA = Integer.parseInt(edtOpSumaA.getText().toString());
                int numeroB = Integer.parseInt(edtOpSumaB.getText().toString());
                int resultado = numeroA + numeroB;

                intent.putExtra("operacion", "sumar");
                intent.putExtra("numeroA", numeroA);
                intent.putExtra("numeroB", numeroB);
                intent.putExtra("resultado", resultado);

                startActivity(intent);
            }
        });
    }
}