package ru.myitschool.vsu.g5_2021.vuzopedia;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    public static VuzService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(VuzService.class);
    }
}
