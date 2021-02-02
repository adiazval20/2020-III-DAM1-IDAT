package edu.idat.idatgram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;
import edu.idat.idatgram.viewmodel.PostViewModel;

public class PostActivity extends AppCompatActivity {
    private PostViewModel viewModel;
    private FirebaseStorage storage;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_TAKE_PICTURE = 2;
    private ImageView imgFoto;
    private MaterialButton btnTomarFoto, btnGuardar;
    private EditText edtDescripcion;
    private String rutaFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        storage = FirebaseStorage.getInstance();

        imgFoto = findViewById(R.id.imgFoto);
        btnTomarFoto = findViewById(R.id.btnTomarFoto);
        btnGuardar = findViewById(R.id.btnGuardar);
        edtDescripcion = findViewById(R.id.edtDescripcion);

        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarCamara();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(rutaFoto);

                Post post = new Post();
                post.setNombreImagen(file.getName());
                post.setRutaImagen(rutaFoto);
                post.setDescripcion(edtDescripcion.getText().toString());
                viewModel.save(post);

                uploadFile(file);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                Bundle extras = data.getExtras();
                Bitmap foto = (Bitmap) extras.get("data");
                imgFoto.setImageBitmap(foto);
            }

            if (requestCode == REQUEST_TAKE_PICTURE) {
                mostrarFoto(imgFoto);
            }
        }
    }

    private void cargarCamara() {
        Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (fotoIntent.resolveActivity(getPackageManager()) != null) {
            File foto = null;
            try {
                foto = crearArchivoImagen();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (foto != null) {
                Uri uri = FileProvider.getUriForFile(this, "edu.idat.idatgram.fileprovider", foto);
                fotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(fotoIntent, REQUEST_TAKE_PICTURE);
            }
        }
    }

    private File crearArchivoImagen() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreArchivo = "JPG_" + timestamp + "_";
        File dirAlmacenamiento = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreArchivo, ".jpg", dirAlmacenamiento);

        rutaFoto = imagen.getAbsolutePath();
        return imagen;
    }

    /**
     * Subir un archivo al servicio de Firebase Storage
     * @param file -> Archivo local en el que se está almacenando la fotografía
     */
    private void uploadFile(File file) {
        // Ruta en el servicio (nube) donde se alojará el archivo
        String path = "fotos/" + file.getName();

        // Obtenemos la referencia de la ruta en la nube
        StorageReference reference = storage.getReference(path);

        // Subimos el archivo
        Uri uri = Uri.fromFile(file);
        UploadTask task = reference.putFile(uri);
        task.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(PostActivity.this, "Archivo subido correctamente", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                finish();
            }
        });
    }

    private void mostrarFoto(ImageView imageView) {
        BitmapFactory.Options opciones = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(rutaFoto, opciones);
        imageView.setImageBitmap(bitmap);
    }
}