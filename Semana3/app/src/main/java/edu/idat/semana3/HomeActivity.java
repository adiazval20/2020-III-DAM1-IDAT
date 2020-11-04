package edu.idat.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText edtNombre = findViewById(R.id.edtNombre);
        Button btnSaludar = findViewById(R.id.btnSaludar);
        final TextView txtSaludo = findViewById(R.id.txtSaludo);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSaludo.setText("Hola, " + edtNombre.getText().toString());
            }
        });
    }
}