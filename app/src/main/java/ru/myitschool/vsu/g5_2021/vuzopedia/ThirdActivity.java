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
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allFaculties;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allVuzes;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.vuzDescription;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FAC_CODE_ARG = "facCode";
Button backbuttonvgpu;
private FacultiesListAdapter adapter2;
    private String facCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vgpu);
        facCode = getIntent().getStringExtra(FAC_CODE_ARG);
        backbuttonvgpu = (Button) findViewById(R.id.backbutton);
        backbuttonvgpu.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.list2);
        adapter2 = new FacultiesListAdapter(this);
        list.setAdapter(adapter2);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vuzDescription vuz = adapter2.get;
                Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
                intent.putExtra(ThirdActivity., );
                startActivity(intent);
            };
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbuttonthird:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
    private void loadFacultiesList(){
        ServiceProvider2.getService2().getListOfAllFaculties().enqueue(new Callback<allFaculties>() {
            @Override
            public void onResponse(Call<allFaculties> call, Response<allFaculties> response) {
                if (response.isSuccessful()){
                    adapter2.refresh2(response.body().faculties);
                }
            }

            @Override
            public void onFailure(Call<allFaculties> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}