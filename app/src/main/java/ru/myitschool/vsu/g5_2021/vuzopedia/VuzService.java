package ru.myitschool.vsu.g5_2021.vuzopedia;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allVuzes;

public interface VuzService {
    @GET("/vuzes.json")
    Call<allVuzes> getListOfAllVuzes();
}
