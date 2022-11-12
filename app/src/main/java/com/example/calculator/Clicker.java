package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clicker{
    private final TextView bottomScreen;
    private final TextView topScreen;
    private int firstValue = 0;
    private int secondValue = 0;
    private StringBuilder stringBuilder;
    private Button btn;
    String getSign;

    public Clicker(TextView bottomScreen, TextView topScreen) {
        this.bottomScreen = bottomScreen;
        this.topScreen = topScreen;
    }

    public void print(View view, CharSequence text) {
        view.setOnClickListener(v -> {
            bottomScreen.append(text);
        });
    }

    public void getFirstValue(Button btn, String sign) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue = Integer.parseInt(String.valueOf(bottomScreen.getText()));
                topScreen.append(bottomScreen.getText() + sign);
                bottomScreen.setText("");
                getSign = sign;
            }
        });
    }


    public void getResult(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondValue = Integer.parseInt(String.valueOf(bottomScreen.getText()));
                topScreen.append(bottomScreen.getText() + "=");
                bottomScreen.setText("");
                switch (getSign) {
                    case "+": {
                        bottomScreen.setTextSize(60);
                        bottomScreen.setText(String.valueOf(firstValue + secondValue));
                        break;
                    }
                    case "-": {
                        bottomScreen.setText(String.valueOf(firstValue - secondValue));
                        break;
                    }
                    case "/": {
                        bottomScreen.setText(String.valueOf(firstValue / secondValue));
                        break;
                    }
                    case "*": {
                        bottomScreen.setText(String.valueOf(firstValue * secondValue));
                        break;
                    }
                }
            }
        });
    }

//    public void formatter(CharSequence charSequence) {
//        for (int i = 0; i < charSequence.length(); i++) {
//             if (charSequence.charAt(i) != '+') {
//                 stringBuilder.append(charSequence.charAt(i));
//             }
//        }
//        firstValue = Integer.parseInt(String.valueOf(stringBuilder));
//    }


}
