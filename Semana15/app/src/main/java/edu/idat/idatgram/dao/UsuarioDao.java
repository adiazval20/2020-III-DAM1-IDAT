package edu.idat.idatgram.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import edu.idat.idatgram.entity.Usuario;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM Usuario WHERE username = :username AND password = :password")
    LiveData<Usuario> login(String username, String password);

    @Insert
    long insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
}
