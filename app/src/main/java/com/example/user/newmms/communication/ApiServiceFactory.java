package com.example.user.newmms.communication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiServiceFactory {
    public static MessageApi createService(String url, String user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getClient(user))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(MessageApi.class);
    }

    private static OkHttpClient getClient(final String user) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().addHeader("Authorization", user).build();
                        return chain.proceed(request);
                    }
                }
        ).build();

        return client;
    }
}
