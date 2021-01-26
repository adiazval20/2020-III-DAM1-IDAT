package edu.idat.idatgram.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import edu.idat.idatgram.R;
import edu.idat.idatgram.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private int layout;
    private ImageView imgFotografia;
    private TextView txtDesripcion;

    public PostViewHolder(@NonNull View itemView, int layout) {
        super(itemView);
        this.layout = layout;
        imgFotografia = itemView.findViewById(R.id.imgFotografia);
        txtDesripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Post post) {
        Bitmap bitmap;

        switch (layout) {
            case R.layout.item_post:
                txtDesripcion.setText(post.getDescripcion());
                bitmap = getBitmap(post.getRutaImagen());
                imgFotografia.setImageBitmap(bitmap);
                break;
            case R.layout.item_post_resume:
                bitmap = getBitmap(post.getRutaImagen());
                imgFotografia.setImageBitmap(bitmap);
                break;
        }

    }

    public Bitmap getBitmap(String rutaFoto) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        return BitmapFactory.decodeFile(rutaFoto, options);
    }
}
