package edu.idat.idatgram.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;

public class PostReviewViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public PostReviewViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public LiveData<Post> find(long id) {
        return postRepo.find(id);
    }
}
