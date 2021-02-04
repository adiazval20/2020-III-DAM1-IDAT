package edu.idat.idatgram.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.idatgram.api.PostApi;
import edu.idat.idatgram.api.ResponseListApi;
import edu.idat.idatgram.config.AppDatabase;
import edu.idat.idatgram.config.RetrofitConfig;
import edu.idat.idatgram.dao.PostDao;
import edu.idat.idatgram.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private PostDao dao;
    private PostApi api;
    private boolean flagListApi = false;

    public PostRepository(Application application) {
        dao = AppDatabase.getDatabase(application).postDao();
        api = RetrofitConfig.getPostApi();
    }

    public LiveData<List<Post>> list() {
        if (!flagListApi) {
            listApi();
        }
        return dao.list();
    }

    private void listApi() {
        flagListApi = true;

        api.list().enqueue(new Callback<ResponseListApi<List<Post>>>() {
            @Override
            public void onResponse(Call<ResponseListApi<List<Post>>> call, Response<ResponseListApi<List<Post>>> response) {
                List<Post> posts = response.body().getData();

                AppDatabase.dbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.deleteAl();

                        for (Post post : posts) {
                            dao.insert(post);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseListApi<List<Post>>> call, Throwable t) {

            }

            @Override
            protected void finalize() throws Throwable {
                flagListApi = false;
            }
        });
    }

    public LiveData<Post> find(String id) {
        if (!flagListApi) {
            findApi(id);
        }
        return dao.find(id);
    }

    private void findApi(String id) {
        flagListApi = true;

        api.find(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();

                AppDatabase.dbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.update(post);
                    }
                });
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }

            @Override
            protected void finalize() throws Throwable {
                flagListApi = false;
            }
        });
    }

    public void save(Post post) {
        AppDatabase.dbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (post.getId().trim().equals("")) {
                    dao.insert(post);
                } else {
                    dao.update(post);
                }
            }
        });
    }
}
