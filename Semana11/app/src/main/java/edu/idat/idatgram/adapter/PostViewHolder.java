package edu.idat.idatgram.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.idat.idatgram.R;
import edu.idat.idatgram.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgFotografia;
    private TextView txtDesripcion;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        imgFotografia = itemView.findViewById(R.id.imgFotografia);
        txtDesripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Post post) {
        txtDesripcion.setText(post.getDescripcion());

        Bitmap bitmap = getBitmap(post.getRutaImagen());
        imgFotografia.setImageBitmap(bitmap);
    }

    public Bitmap getBitmap(String rutaFoto) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        return BitmapFactory.decodeFile(rutaFoto, options);
    }
}
