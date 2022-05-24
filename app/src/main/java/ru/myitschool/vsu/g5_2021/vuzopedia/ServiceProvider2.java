package ru.myitschool.vsu.g5_2021.vuzopedia;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider2{
    public static FacultyService getService2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.72.3")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(FacultyService.class);
    }
}
