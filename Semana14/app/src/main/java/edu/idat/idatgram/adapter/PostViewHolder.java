package edu.idat.idatgram.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import edu.idat.idatgram.R;
import edu.idat.idatgram.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private FirebaseStorage storage;
    private int layout;
    private ImageView imgFotografia;
    private TextView txtDesripcion;

    public PostViewHolder(@NonNull View itemView, int layout) {
        super(itemView);

        storage = FirebaseStorage.getInstance();

        this.layout = layout;
        imgFotografia = itemView.findViewById(R.id.imgFotografia);
        txtDesripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Post post) {
        if (layout == R.layout.item_post) {
            txtDesripcion.setText(post.getDescripcion());
        }

        try {
            File localFile = File.createTempFile("images", "jpg");

            // Ruta de la nube donde está almacenado el archivo
            String path = "fotos/" + post.getNombreImagen();

            // Obtenemos la referencia
            StorageReference reference = storage.getReference(path);
            reference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = getBitmap(localFile.getAbsolutePath());
                    imgFotografia.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(itemView.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Bitmap getBitmap(String rutaFoto) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        return BitmapFactory.decodeFile(rutaFoto, options);
    }
}
