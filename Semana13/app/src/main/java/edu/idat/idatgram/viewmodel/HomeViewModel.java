package edu.idat.idatgram.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;

public class HomeViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public LiveData<List<Post>> list() {
        return postRepo.list();
    }
}
