package edu.idat.semana6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Producto;

public class ProductoAdapter extends ArrayAdapter<Producto> {
    public ProductoAdapter(@NonNull Context context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_producto, parent, false);
        }

        Producto producto = getItem(position);

        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        TextView txtPrecio = convertView.findViewById(R.id.txtPrecio);
        txtPrecio.setText(String.format("Precio: %.2f", producto.getPrecio()));

        return convertView;
    }
}
