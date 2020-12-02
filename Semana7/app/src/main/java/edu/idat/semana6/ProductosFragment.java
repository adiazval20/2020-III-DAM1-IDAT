package edu.idat.semana6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.adapter.ProductoAdapter;
import edu.idat.semana6.entity.Producto;

public class ProductosFragment extends Fragment {

    public ProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_productos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rcvProductos = view.findViewById(R.id.rcvProductos);
        rcvProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto 1", "", 1500, 0));
        productos.add(new Producto(2, "Producto 2", "", 2000, 0));
        productos.add(new Producto(3, "Producto 3", "", 2500, 0));

        ProductoAdapter adapter = new ProductoAdapter(productos);
        rcvProductos.setAdapter(adapter);
    }
}