package ru.myitschool.vsu.g5_2021.vuzopedia;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    public static VuzService getService(){
       // HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       // OkHttpClient client = new OkHttpClient.Builder()

                //.addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://raw.githubusercontent.com/p1an7/university2.json/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(VuzService.class);
    }

}
