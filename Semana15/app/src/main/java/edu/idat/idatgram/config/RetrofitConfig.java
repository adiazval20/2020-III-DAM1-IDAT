package edu.idat.idatgram.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import edu.idat.idatgram.api.PostApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit client;
    private static PostApi postApi;

    static {
        String baseUrl = "https://dummyapi.io/data/api/";
        client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClientBuilder().build())
                .build();
    }

    private static OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(log);

        builder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request auth = chain.request().newBuilder()
                        .addHeader("app-id", "6014597c989c2242753fe082")
                        .build();
                return chain.proceed(auth);
            }
        });

        return builder;
    }

    public static PostApi getPostApi() {
        if (postApi == null) {
            postApi = client.create(PostApi.class);
        }
        return postApi;
    }
}
