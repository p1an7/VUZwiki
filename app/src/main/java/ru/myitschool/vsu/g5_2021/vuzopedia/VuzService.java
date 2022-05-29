package ru.myitschool.vsu.g5_2021.vuzopedia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allFaculties;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allSpecialities;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allVuzes;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.facultyDescription;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.facultyDetails;

public interface VuzService {
    @GET("university.json")
    Call<allVuzes> getListOfAllVuzes();
    @GET("{vuzCode}/description.json")
    Call<allFaculties> getListOfAllFacultiesFor(@Path("vuzCode") String vuzCode);
    @GET("{vuzCode}/{facCode}.json")
    Call<facultyDetails> getListOfAllSpeciailtiesFor(@Path("vuzCode") String vuzCode, @Path("facCode") String facCode);
}
