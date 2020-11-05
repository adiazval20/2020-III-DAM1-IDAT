package edu.idat.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private EditText edtNombre;
    private TextView txtSaludo;
    private Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        edtNombre = findViewById(R.id.edtNombre);
//        btnSaludar = findViewById(R.id.btnSaludar);
        txtSaludo = findViewById(R.id.txtSaludo);
//
//        btnSaludar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mostrarSaludo(edtNombre.getText().toString());
//            }
//        });

//        Bundle data = getIntent().getExtras();
//        String nombre = (data != null) ? data.getString("nombre") : "";
//
//        mostrarSaludo(nombre);

        Bundle data = getIntent().getExtras();
        String operacion = data.getString("operacion");
        int numeroA = data.getInt("numeroA");
        int numeroB = data.getInt("numeroB");
        int resultado = data.getInt("resultado");

        txtSaludo.setText(String.format("El resultado de %s %d y %d es: %d", operacion, numeroA, numeroB, resultado));

//        mostrarSaludo(String.valueOf(numeroA, numeroB, resultado));
    }

//    private void mostrarSaludo(String nombre) {
//        txtSaludo.setText("Hola, " + nombre);
//    }
}