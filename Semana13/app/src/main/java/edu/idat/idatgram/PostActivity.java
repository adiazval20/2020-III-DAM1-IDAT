package edu.idat.idatgram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

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

import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;

public class PostActivity extends AppCompatActivity {
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
                Post post = new Post();
                post.setRutaImagen(rutaFoto);
                post.setDescripcion(edtDescripcion.getText().toString());
//                PostRepository.getInstance().save(post);
                finish();
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
                guardarFoto();
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

    private void guardarFoto() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File file = new File(rutaFoto);
        Uri uri = Uri.fromFile(file);
        mediaScanIntent.setData(uri);
        sendBroadcast(mediaScanIntent);
    }

    private void mostrarFoto(ImageView imageView) {
        int anchoImageView = imageView.getWidth();
        int altoImageView = imageView.getHeight();

        BitmapFactory.Options opciones = new BitmapFactory.Options();
        opciones.inJustDecodeBounds = true;

        int anchoFoto = opciones.outWidth;
        int altoFoto = opciones.outHeight;

        int factorEscala = Math.min(anchoFoto / anchoImageView, altoFoto / altoImageView);
        opciones.inJustDecodeBounds = false;
        opciones.inSampleSize = factorEscala;

        Bitmap bitmap = BitmapFactory.decodeFile(rutaFoto, opciones);
        imageView.setImageBitmap(bitmap);
    }
}