package edu.idat.idatgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import edu.idat.idatgram.api.PostApi;
import edu.idat.idatgram.config.RetrofitConfig;
import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.viewmodel.PostReviewViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostReviewActivity extends AppCompatActivity {
    private PostReviewViewModel viewModel;
    private FirebaseStorage storage;
    private ImageView imgFotografia;
    private TextView txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);

        viewModel = new ViewModelProvider(this).get(PostReviewViewModel.class);
        storage = FirebaseStorage.getInstance();

        imgFotografia = findViewById(R.id.imgFotografia);
        txtDescripcion = findViewById(R.id.txtDescripcion);

        Bundle data = getIntent().getExtras();
        String id = (data == null) ? "" : data.getString("id");

        viewModel.find(id).observe(this, new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                txtDescripcion.setText(post.getText());
                Picasso.get().load(post.getImage()).into(imgFotografia);
            }
        });
    }

    private void loadFotografia(Post post) {
        try {
            File localFile = File.createTempFile("images", "jpg");
            String path = "fotos/" + post.getImage();
            StorageReference reference = storage.getReference(path);
            reference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath(), new BitmapFactory.Options());
                    imgFotografia.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(PostReviewActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}