package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CLICKER = "Clicker";
    private Clicker clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clicker = new Clicker(findViewById(R.id.bottom_screen), findViewById(R.id.top_screen));



        clicker.print(findViewById(R.id.key_1),"1");
        clicker.print(findViewById(R.id.key_2),"2");
        clicker.print(findViewById(R.id.key_3),"3");
        clicker.print(findViewById(R.id.key_4),"4");
        clicker.print(findViewById(R.id.key_5),"5");
        clicker.print(findViewById(R.id.key_6),"6");
        clicker.print(findViewById(R.id.key_7),"7");
        clicker.print(findViewById(R.id.key_8),"8");
        clicker.print(findViewById(R.id.key_9),"9");
        clicker.print(findViewById(R.id.key_0),"0");
        clicker.print(findViewById(R.id.key_dot),".");

        clicker.getFirstValue(findViewById(R.id.key_plus), "+");
        clicker.getFirstValue(findViewById(R.id.key_minus), "-");
        clicker.getFirstValue(findViewById(R.id.key_multi), "*");
        clicker.getFirstValue(findViewById(R.id.key_divide), "/");

        clicker.getResult(findViewById(R.id.key_result));
        clicker.clear(findViewById(R.id.key_clear));
        clicker.back(findViewById(R.id.key_back));

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

}