package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            case R.id.optProductos:
                fragment = new ProductosFragment();
                break;
            case R.id.optContacto:
                fragment = new ContactoFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.move_left_in, R.anim.move_left_out);
        transaction.replace(R.id.frmContenedor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}