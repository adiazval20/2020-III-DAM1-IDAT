package edu.idat.semana6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        ListView lsvProductos = view.findViewById(R.id.lsvProductos);

//        List<String> productos = new ArrayList<>();
//        productos.add("Producto 1");
//        productos.add("Producto 2");
//        productos.add("Producto 3");
//        productos.add("Producto 4");
//        productos.add("Producto 5");
//        productos.add("Producto 6");
//        productos.add("Producto 7");
//        productos.add("Producto 8");
//
//        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, productos);
//
//        lsvProductos.setAdapter(adapter);

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto 1", "", 1500, 0));
        productos.add(new Producto(2, "Producto 2", "", 2000, 0));
        productos.add(new Producto(3, "Producto 3", "", 2500, 0));

        ProductoAdapter adapter = new ProductoAdapter(getContext(), R.layout.item_producto, productos);
        lsvProductos.setAdapter(adapter);
    }
}