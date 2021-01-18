package edu.idat.idatgram;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.idatgram.dao.UsuarioDao;
import edu.idat.idatgram.entity.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase DB;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract UsuarioDao usuarioDao();

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
                    UsuarioDao dao = DB.usuarioDao();
                    dao.insert(new Usuario("admin", "admin"));
                    dao.insert(new Usuario("user", "123456"));
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
        }
    };
}
