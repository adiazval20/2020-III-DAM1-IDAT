package edu.idat.idatgram.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;

public class PostViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public PostViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public void save(Post post) {
        postRepo.save(post);
    }
}
