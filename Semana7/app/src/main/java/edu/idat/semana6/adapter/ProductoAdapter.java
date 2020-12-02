package edu.idat.semana6.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    private List<Producto> productos;

    public ProductoAdapter() {
        this.productos = new ArrayList<>();
    }

    public ProductoAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.loadData(producto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}
