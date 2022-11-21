package com.example.calculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class Clicker implements Parcelable {
    private double firstValue;
    private double secondValue;
    private double result;
    String getSign;
    Boolean restart = false;


    public Clicker() {
    }


    protected Clicker(Parcel in) {
        firstValue = in.readDouble();
        secondValue = in.readDouble();
        result = in.readDouble();
        getSign = in.readString();
        byte tmpRestart = in.readByte();
        restart = tmpRestart == 0 ? null : tmpRestart == 1;
    }

    public static final Creator<Clicker> CREATOR = new Creator<Clicker>() {
        @Override
        public Clicker createFromParcel(Parcel in) {
            return new Clicker(in);
        }

        @Override
        public Clicker[] newArray(int size) {
            return new Clicker[size];
        }
    };

    public void print(TextView bottomScreen, TextView topScreen, View view, CharSequence text) {
        view.setOnClickListener(v -> {
            if (restart && firstValue == 0) {
                restart(bottomScreen, topScreen);
            }
            restart = false;
            bottomScreen.append(text);
        });
    }

    public void getFirstValue(TextView bottomScreen, TextView topScreen,View view, String sign) {
        view.setOnClickListener(v -> {
            if (bottomScreen.length() > 0) {
                firstValue = Double.parseDouble(String.valueOf(bottomScreen.getText()));
                topScreen.append(bottomScreen.getText() + sign);
                bottomScreen.setText("");
                getSign = sign;
            }
        });
    }


    public void getResult(TextView bottomScreen, TextView topScreen,View view) {
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

    public void clear(TextView bottomScreen, TextView topScreen,View view) {
        view.setOnClickListener(v -> {
            firstValue = 0;
            secondValue = 0;
            bottomScreen.setText("");
            bottomScreen.setTextSize(30);
            topScreen.setText("");
            getSign = "";
        });
    }

    public void back(TextView bottomScreen, TextView topScreen,View view) {
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

    public void restart(TextView bottomScreen, TextView topScreen) {
        topScreen.append(bottomScreen.getText());
        topScreen.append("\n");
        bottomScreen.setText("");
        getSign = "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(firstValue);
        dest.writeDouble(secondValue);
        dest.writeDouble(result);
        dest.writeString(getSign);
        dest.writeByte((byte) (restart == null ? 0 : restart ? 1 : 2));
    }


    //TODO - разобраться с приведением типов, сейчас все конвертируется и считается в double, надо сделать так чтобы работало в зависимости от типов данных
    //TODO - разобраться с неизменяемостью операторов, сейчас поставил заглушку на повторное нажатие знака, все работает, но если допустим я хочу поменять знак оператора с одного на другой, этого не происходит

}
