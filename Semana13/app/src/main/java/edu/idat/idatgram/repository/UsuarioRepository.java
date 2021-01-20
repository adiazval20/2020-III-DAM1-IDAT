package edu.idat.idatgram.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import edu.idat.idatgram.AppDatabase;
import edu.idat.idatgram.dao.UsuarioDao;
import edu.idat.idatgram.entity.Usuario;

public class UsuarioRepository {
    private UsuarioDao dao;

    public UsuarioRepository(Application application) {
        dao = AppDatabase.getDatabase(application).usuarioDao();
    }

    public LiveData<Usuario> login(String username, String password) {
        return dao.login(username, password);
    }
}
