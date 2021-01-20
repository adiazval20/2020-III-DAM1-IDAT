package edu.idat.idatgram;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.idatgram.dao.PostDao;
import edu.idat.idatgram.dao.UsuarioDao;
import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.entity.Usuario;

@Database(entities = {Usuario.class, Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract UsuarioDao usuarioDao();

    public abstract PostDao postDao();

    public static AppDatabase getDatabase(Context context) {
        if (DB == null) {
            synchronized (AppDatabase.class) {
                if (DB == null) {
                    DB = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DAM2-IDATGRAM")
                            .addCallback(initCallback)
                            .build();
                }
            }
        }
        return DB;
    }

    private static Callback initCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            dbExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    UsuarioDao usuarioDao = DB.usuarioDao();
                    usuarioDao.insert(new Usuario("admin", "admin"));
                    usuarioDao.insert(new Usuario("user", "123456"));

                    PostDao postDao = DB.postDao();
                    postDao.insert(new Post("https://i.blogs.es/92ef6b/650_1000_rpi-2-3/375_142.jpg", "Post 1"));
                    postDao.insert(new Post("https://i.blogs.es/7f770c/image-2020-07-13-10-21-48/375_142.jpg", "Post 2"));
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
        }
    };
}
