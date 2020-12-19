package edu.idat.idatgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    private HashMap<Integer, Integer> posicionesFragment;
    private int ultimaPosicionSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ultimaPosicionSeleccionada = 0;

        posicionesFragment = new HashMap<>();
        posicionesFragment.put(R.id.optInicio, 1);
        posicionesFragment.put(R.id.optBuscar, 2);
        posicionesFragment.put(R.id.optPerfil, 3);

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        BottomNavigationView bnvSecciones = findViewById(R.id.bnvSecciones);
        bnvSecciones.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                ultimaPosicionSeleccionada = posicionesFragment.get(item.getItemId());
                return true;
            }
        });

        loadFragment(R.id.optInicio);
    }

    private void loadFragment(int itemId) {
        int posicionActual = posicionesFragment.get(itemId);
        if (posicionActual != ultimaPosicionSeleccionada) {
            Fragment fragment = new Fragment();

            switch (itemId) {
                case R.id.optInicio:
                    fragment = new InicioFragment();
                    break;
                case R.id.optBuscar:
                    fragment = new BuscarFragment();
                    break;
                case R.id.optPerfil:
                    fragment = new PerfilFragment();
                    break;
            }

            int animacionIn, animacionOut;
            if (posicionActual > ultimaPosicionSeleccionada) {
                animacionIn = R.anim.slide_right_to_left_in;
                animacionOut = R.anim.slide_right_to_left_out;
            } else {
                animacionIn = R.anim.slide_left_to_right_in;
                animacionOut = R.anim.slide_left_to_right_out;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(animacionIn, animacionOut);
            transaction.replace(R.id.frmSeccion, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}