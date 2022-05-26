package ru.myitschool.vsu.g5_2021.vuzopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FourthActivity extends AppCompatActivity {
    public static final String FAC_CODE_ARG = "facCode";
    public static final String VUZ_CODE_ARG = "vuzCode";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }
}