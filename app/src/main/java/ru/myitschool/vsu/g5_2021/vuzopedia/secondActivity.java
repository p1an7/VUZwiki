package ru.myitschool.vsu.g5_2021.vuzopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.allVuzes;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.vuzDescription;


public class secondActivity extends AppCompatActivity implements OnClickListener {
    Button backbutton;
    private VuzesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        backbutton = (Button) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.list);
         adapter = new VuzesListAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vuzDescription vuz = adapter.getVuz(position);
                Intent intent = new Intent(secondActivity.this, ThirdActivity.class);
                intent.putExtra(ThirdActivity.VUZ_CODE_ARG, vuz.code);
                startActivity(intent);
            }
        });
        loadVuzesList();
    }
    private void loadVuzesList(){
        ServiceProvider.getService().getListOfAllVuzes().enqueue(new Callback<allVuzes>() {
            @Override
            public void onResponse(Call<allVuzes> call, Response<allVuzes> response) {
                if (response.isSuccessful()){
                    adapter.refresh(response.body().vuzes);
                }
            }

            @Override
            public void onFailure(Call<allVuzes> call, Throwable t) {
            t.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton:
                finish();
                break;

        }
    }

    //String[] spisok = {"Воронежский государственный педагогический университет", "Воронежский государственный университет", "Воронежский институт МВД России", "Международный институт компьютерных технологий", "Воронежский институт федеральной службы исполнения наказаний Российской Федерации", "Воронежский филиал Российского экономического университета имени Г.В. Плеханова", "Воронежский институт (филиал) Московского гуманитарно-экономического университета", "Воронежский институт высоких технологий", "Воронежский государственный медицинский университет им. Бурденко", "Воронежский государственный технический университет", "Воронежский государственный университет инженерных технологий", "Воронежский государственный аграрный университет им. императора Петра I", "Воронежский государственный лесотехнический университет имени Г. Ф. Морозова", "Военно-воздушная академия им. проф. Н.Е. Жуковского и Ю.А. Гагарина", "Воронежский государственный институт искусств", "Воронежский экономико-правовой институт", "Воронежский государственный институт физической культуры", "Воронежский институт экономики и социального управления", "Воронежский филиал Ростовского государственного университета путей сообщения", "Воронежский филиал Российской академии народного хозяйства и государственной службы при Президенте РФ", "Воронежский филиал ГУМРФ им Макарова", "Центральный филиал РГУП"};

}