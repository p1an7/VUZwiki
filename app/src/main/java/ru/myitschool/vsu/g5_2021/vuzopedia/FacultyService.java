package ru.myitschool.vsu.g5_2021.vuzopedia;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allFaculties;

public interface FacultyService {
    @GET("")
    Call<allFaculties> getListOfAllFaculties();
}
