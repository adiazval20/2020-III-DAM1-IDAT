package edu.idat.semana6.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.idat.semana6.R;
import edu.idat.semana6.entity.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    private CircleImageView imgProducto;
    private ImageView imgProductoGrande;
    private TextView txtNombre, txtPrecio, txtDescripcion;

    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);

        imgProducto = itemView.findViewById(R.id.imgProducto);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        imgProductoGrande = itemView.findViewById(R.id.imgProductoGrande);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Producto producto) {
        imgProducto.setImageResource(producto.getImagenId());
        txtNombre.setText(producto.getNombre());
        txtPrecio.setText(String.format("Precio: %.2f", producto.getPrecio()));
        imgProductoGrande.setImageResource(producto.getImagenId());
        txtDescripcion.setText(producto.getDescripcion());
    }
}
