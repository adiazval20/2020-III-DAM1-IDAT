package edu.idat.idatgram.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import edu.idat.idatgram.AppDatabase;
import edu.idat.idatgram.dao.PostDao;
import edu.idat.idatgram.entity.Post;

public class PostRepository {
    private PostDao dao;

    public PostRepository(Application application) {
        dao = AppDatabase.getDatabase(application).postDao();
    }

    public LiveData<List<Post>> list() {
        return dao.list();
    }

    public LiveData<Post> find(long id) {
        return dao.find(id);
    }

    public void save(Post post) {
        AppDatabase.dbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (post.getId() == 0) {
                    dao.insert(post);
                } else {
                    dao.update(post);
                }
            }
        });
    }
}
