package edu.idat.idatgram.api;

import java.util.List;

import edu.idat.idatgram.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("post")
    Call<ResponseListApi<List<Post>>> list();

    @GET("post/{id}")
    Call<Post> find(@Path("id") String id);
}
