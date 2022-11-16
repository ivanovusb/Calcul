package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    public static final String THEME_LIGHT = "THEME_LIGHT";
    public static final String THEME_DARK = "THEME_DARK";
    public static final String THEME_KEY = "THEME_KEY";
    public static final String CLICKER = "Clicker";
    private Clicker clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);

        String theme = sharedPreferences.getString(THEME_KEY, THEME_LIGHT);

        if (THEME_DARK.equals(theme)) {
            setTheme(R.style.Theme_Calculator_Dark);
        } else {
            setTheme(R.style.Theme_Calculator);
        }

        setContentView(R.layout.activity_main);

        ImageView icon = findViewById(R.id.icon_theme);
        SwitchMaterial themeChanger = findViewById(R.id.theme_changer);
        if (themeChanger.isChecked()) {
            icon.setImageResource(R.drawable.ic_moon_ic);
        } else {
            icon.setImageResource(R.drawable.ic_sun_icon);
        }



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



        themeChanger.setOnClickListener(v -> {
            if (themeChanger.isChecked()) {
                sharedPreferences.edit()
                        .putString(THEME_KEY, THEME_DARK)
                        .apply();
            } else {
                sharedPreferences.edit()
                        .putString(THEME_KEY, THEME_LIGHT)
                        .apply();
            }
            recreate();
        });







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