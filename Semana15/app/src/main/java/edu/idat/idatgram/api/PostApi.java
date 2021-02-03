package edu.idat.idatgram.api;

import java.util.List;

import edu.idat.idatgram.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("post")
    Call<ResponseListApi<List<Post>>> list();
}
