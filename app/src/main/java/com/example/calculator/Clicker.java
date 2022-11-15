package com.example.calculator;

import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class Clicker implements Serializable {
    private final TextView bottomScreen;
    private final TextView topScreen;
    private double firstValue = 0;
    private double secondValue = 0;
    private double result;
    String getSign;
    Boolean restart = false;

    public Clicker(TextView bottomScreen, TextView topScreen) {
        this.bottomScreen = bottomScreen;
        this.topScreen = topScreen;
    }

    public void print(View view, CharSequence text) {
        view.setOnClickListener(v -> {
            if (restart && topScreen.getText() == null) {
                restart();
            }
            restart = false;
            bottomScreen.append(text);
        });
    }

    public void getFirstValue(View view, String sign) {
        view.setOnClickListener(v -> {
            if (bottomScreen.length() > 0) {
                firstValue = Double.parseDouble(String.valueOf(bottomScreen.getText()));
                topScreen.append(bottomScreen.getText() + sign);
                bottomScreen.setText("");
                getSign = sign;
            }
        });
    }


    public void getResult(View view) {
        view.setOnClickListener(v -> {
            if (getSign != null && bottomScreen.length() > 0) {
                secondValue = Double.parseDouble(String.valueOf(bottomScreen.getText()));
                topScreen.append(bottomScreen.getText() + "=");
                bottomScreen.setText("");
                switch (getSign) {
                    case "+": {
                        result = firstValue + secondValue;
                        bottomScreen.append("" + result);
                        break;
                    }
                    case "-": {
                        result = firstValue - secondValue;
                        bottomScreen.append("" + result);
                        break;
                    }
                    case "/": {
                        result = firstValue / secondValue;
                        bottomScreen.append("" + result);
                        break;
                    }
                    case "*": {
                        result = firstValue * secondValue;
                        bottomScreen.append("" + result);
                        break;
                    }
                }
            }
            bottomScreen.setTextSize(50);
            restart = true;
            firstValue = 0;
            secondValue = 0;
        });
    }

    public void clear(View view) {
        view.setOnClickListener(v -> {
            firstValue = 0;
            secondValue = 0;
            bottomScreen.setText("");
            bottomScreen.setTextSize(30);
            topScreen.setText("");
            getSign = "";
        });
    }

    public void back(View view) {
        view.setOnClickListener(v -> {
            try {
                if (bottomScreen.length() > 0) {
                    StringBuilder sb = new StringBuilder(bottomScreen.getText());
                    sb.deleteCharAt(sb.length() - 1);
                    bottomScreen.setText(sb);
                }
                if (bottomScreen.length() == 0) {
                    StringBuilder sb = new StringBuilder(topScreen.getText());
                    sb.deleteCharAt(sb.length() - 1);
                    topScreen.setText(sb);
                }
            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void restart() {
        firstValue = 0;
        secondValue = 0;
        bottomScreen.setText("");
        topScreen.setText("");
        getSign = "";
    }


    //TODO - разобраться с приведением типов, сейчас все конвертируется и считается в double, надо сделать так чтобы работало в зависимости от типов данных
    //TODO - разобраться с неизменяемостью операторов, сейчас поставил заглушку на повторное нажатие знака, все работает, но если допустим я хочу поменять знак оператора с одного на другой, этого не происходит

}
