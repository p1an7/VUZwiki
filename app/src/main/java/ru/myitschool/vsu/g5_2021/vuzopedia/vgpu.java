package ru.myitschool.vsu.g5_2021.vuzopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vgpu extends AppCompatActivity implements View.OnClickListener {
    public static final String VUZ_CODE_ARG = "vuzcode";
Button backbuttonvgpu;
    private String vuzCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vgpu);
        vuzCode = getIntent().getStringExtra(VUZ_CODE_ARG);
        backbuttonvgpu = (Button) findViewById(R.id.backbutton);
        backbuttonvgpu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbuttonvgpu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}