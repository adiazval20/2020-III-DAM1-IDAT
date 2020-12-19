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

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        BottomNavigationView bnvSecciones = findViewById(R.id.bnvSecciones);
        bnvSecciones.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });

        loadFragment(R.id.optInicio);
    }

    private void loadFragment(int itemId) {
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

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_left_to_right_in, R.anim.slide_left_to_right_out);
        transaction.replace(R.id.frmSeccion, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}