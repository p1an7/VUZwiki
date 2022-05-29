package ru.myitschool.vsu.g5_2021.vuzopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.SpecialityListAdapter;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allFaculties;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allSpecialities;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.facultyDescription;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.facultyDetails;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.specialityDescription;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FAC_CODE_ARG = "facCode";
    public static final String VUZ_CODE_ARG = "vuzCode";
    Button backbuttonfourthactivity;
    private SpecialityListAdapter adapter3;
    private String vuzCode = "";
    private String faccode="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        vuzCode = getIntent().getStringExtra(VUZ_CODE_ARG);
        faccode = getIntent().getStringExtra(FAC_CODE_ARG);
        backbuttonfourthactivity = (Button) findViewById(R.id.backbuttonfourthactivity);
        backbuttonfourthactivity.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.list3);
        adapter3 = new SpecialityListAdapter(this);
        list.setAdapter(adapter3);



        loadSpecialityList();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbuttonfourthactivity:
                finish();
        }
    }

    private void loadSpecialityList() {
        ServiceProvider.getService().getListOfAllSpeciailtiesFor(vuzCode,faccode).enqueue(new Callback<facultyDetails>() {
            @Override
            public void onResponse(Call<facultyDetails> call, Response<facultyDetails> response) {
                if (response.isSuccessful()) {
                    adapter3.refresh3(response.body().specialities);
                }
            }

            @Override
            public void onFailure(Call<facultyDetails> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}