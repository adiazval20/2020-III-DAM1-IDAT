package edu.idat.idatgram.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import edu.idat.idatgram.entity.Usuario;
import edu.idat.idatgram.repository.UsuarioRepository;

public class LoginViewModel extends AndroidViewModel {
    private UsuarioRepository usuarioRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        usuarioRepository = new UsuarioRepository(application);
    }

    public LiveData<Usuario> login(String username, String password) {
        return usuarioRepository.login(username, password);
    }
}
