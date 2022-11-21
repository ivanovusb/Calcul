package com.example.calculator.storage;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {
    ONE(R.style.Theme_Calculator, R.string.theme_one, "THEME_ONE"),
    TWO(R.style.Theme_Calculator_Dark, R.string.theme_two, "THEME_TWO");

    private @StyleRes
    final int theme;

    private @StringRes
    final int title;

    public int getTheme() {
        return theme;
    }

    private final String key;

    Theme(int theme, int title, String key) {
        this.theme = theme;
        this.title = title;
        this.key = key;
    }

    public int getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }
}
