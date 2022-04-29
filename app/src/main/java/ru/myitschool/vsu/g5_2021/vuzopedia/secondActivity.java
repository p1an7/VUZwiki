package ru.myitschool.vsu.g5_2021.vuzopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class secondActivity extends AppCompatActivity implements OnClickListener {
    Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        backbutton = (Button) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, spisok);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "itemClick: position = " +
                                position + ", id = " + id + ", " + parent.getAdapter().getItem(position),
                        Toast.LENGTH_SHORT).show();
                if (position==0){
                    Intent intent = new Intent(secondActivity.this, vgpu.class);
                    startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(secondActivity.this, vgpu.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

    String[] spisok = {"Воронежский государственный педагогический университет", "Воронежский государственный университет", "Воронежский институт МВД России", "Международный институт компьютерных технологий", "Воронежский институт федеральной службы исполнения наказаний Российской Федерации", "Воронежский филиал Российского экономического университета имени Г.В. Плеханова", "Воронежский институт (филиал) Московского гуманитарно-экономического университета", "Воронежский институт высоких технологий", "Воронежский государственный медицинский университет им. Бурденко", "Воронежский государственный технический университет", "Воронежский государственный университет инженерных технологий", "Воронежский государственный аграрный университет им. императора Петра I", "Воронежский государственный лесотехнический университет имени Г. Ф. Морозова", "Военно-воздушная академия им. проф. Н.Е. Жуковского и Ю.А. Гагарина", "Воронежский государственный институт искусств", "Воронежский экономико-правовой институт", "Воронежский государственный институт физической культуры", "Воронежский институт экономики и социального управления", "Воронежский филиал Ростовского государственного университета путей сообщения", "Воронежский филиал Российской академии народного хозяйства и государственной службы при Президенте РФ", "Воронежский филиал ГУМРФ им Макарова", "Центральный филиал РГУП"};


}