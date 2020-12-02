package edu.idat.semana6.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.idat.semana6.R;
import edu.idat.semana6.entity.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    private CircleImageView imgProducto;
    private TextView txtNombre, txtPrecio;

    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);

        imgProducto = itemView.findViewById(R.id.imgProducto);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
    }

    public void loadData(Producto producto) {
        
    }
}
