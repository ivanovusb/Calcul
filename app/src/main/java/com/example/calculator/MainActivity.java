package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView bottomScreen = findViewById(R.id.bottom_screen);
        TextView topScreen = findViewById(R.id.top_screen);

        Clicker clicker = new Clicker(bottomScreen, topScreen);

        Button btn1 = findViewById(R.id.key_1);
        Button btn2 = findViewById(R.id.key_2);
        Button btn3 = findViewById(R.id.key_3);
        Button btn4 = findViewById(R.id.key_4);
        Button btn5 = findViewById(R.id.key_5);
        Button btn6 = findViewById(R.id.key_6);
        Button btn7 = findViewById(R.id.key_7);
        Button btn8 = findViewById(R.id.key_8);
        Button btn9 = findViewById(R.id.key_9);
        Button btn0 = findViewById(R.id.key_0);
        Button btnPlus = findViewById(R.id.key_plus);
        Button btnMinus = findViewById(R.id.key_minus);
        Button btnMulti = findViewById(R.id.key_multi);
        Button btnDivide = findViewById(R.id.key_divide);
        Button btnResult = findViewById(R.id.key_result);

        clicker.print(btn1,"1");
        clicker.print(btn2,"2");
        clicker.print(btn3,"3");
        clicker.print(btn4,"4");
        clicker.print(btn5,"5");
        clicker.print(btn6,"6");
        clicker.print(btn7,"7");
        clicker.print(btn8,"8");
        clicker.print(btn9,"9");
        clicker.print(btn0,"0");

        clicker.getFirstValue(btnPlus, "+");
        clicker.getFirstValue(btnMinus, "-");
        clicker.getFirstValue(btnMulti, "*");
        clicker.getFirstValue(btnDivide, "/");
        
        clicker.getResult(btnResult);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}