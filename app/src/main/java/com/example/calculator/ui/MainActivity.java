package com.example.calculator.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculator.Clicker;
import com.example.calculator.R;
import com.example.calculator.storage.Theme;
import com.example.calculator.storage.ThemeStorage;

public class MainActivity extends AppCompatActivity {

    public static final String CLICKER = "CLICKER";
    public static final String BOTTOM_SCREEN = "BOTTOM_SCREEN";
    public static final String TOP_SCREEN = "TOP_SCREEN";
    private Clicker clicker;
    private TextView bottomScreen;
    private TextView topScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeStorage storage = ThemeStorage.getInstance(getApplicationContext());

        Theme savedTheme = storage.getTheme();


        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();

                    Theme chosenTheme = (Theme) data.getSerializableExtra(ThemeSelectionActivity.CHOSEN_THEME);

                    storage.saveTheme(chosenTheme);

                    recreate();
                }
            }
        });

        setTheme(savedTheme.getTheme());

        setContentView(R.layout.activity_main);

        clicker = new Clicker();
        bottomScreen = findViewById(R.id.bottom_screen);
        topScreen = findViewById(R.id.top_screen);

        if (savedInstanceState != null) {
            clicker = savedInstanceState.getParcelable(CLICKER);
            bottomScreen.setText(savedInstanceState.getCharSequence(BOTTOM_SCREEN));
            topScreen.setText(savedInstanceState.getCharSequence(TOP_SCREEN));
        }

        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_1), "1");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_2), "2");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_3), "3");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_4), "4");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_5), "5");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_6), "6");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_7), "7");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_8), "8");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_9), "9");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_0), "0");
        clicker.print(bottomScreen, topScreen, findViewById(R.id.key_dot), ".");

        clicker.getFirstValue(bottomScreen, topScreen, findViewById(R.id.key_plus), "+");
        clicker.getFirstValue(bottomScreen, topScreen, findViewById(R.id.key_minus), "-");
        clicker.getFirstValue(bottomScreen, topScreen, findViewById(R.id.key_multi), "*");
        clicker.getFirstValue(bottomScreen, topScreen, findViewById(R.id.key_divide), "/");

        clicker.getResult(bottomScreen, topScreen, findViewById(R.id.key_result));
        clicker.clear(bottomScreen, topScreen, findViewById(R.id.key_clear));
        clicker.back(bottomScreen, topScreen, findViewById(R.id.key_back));

        findViewById(R.id.icon_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemeSelectionActivity.class);
                intent.putExtra(ThemeSelectionActivity.SELECTED_THEME, savedTheme);

                launcher.launch(intent);
            }
        });

        findViewById(R.id.icon_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://wikipedia.ru");

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);


                startActivity(Intent.createChooser(intent, null));
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CLICKER, clicker);
        outState.putCharSequence(BOTTOM_SCREEN, bottomScreen.getText());
        outState.putCharSequence(TOP_SCREEN, topScreen.getText());
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

}