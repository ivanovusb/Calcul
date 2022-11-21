package com.example.calculator.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeStorage {
    private static final String THEME_KEY = "THEME_KEY";
    private static ThemeStorage INSTANCE;
    private final Context context;
    private SharedPreferences sharedPreferences;


    public static ThemeStorage getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ThemeStorage(context);
        }
        return INSTANCE;
    }

    public ThemeStorage(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);

    }

    public void saveTheme(Theme theme) {
        sharedPreferences.edit()
                .putString(THEME_KEY, theme.getKey())
                .apply();
    }

    public Theme getTheme() {
        String savedValue = sharedPreferences.getString(THEME_KEY, Theme.ONE.getKey());

        for (Theme theme : Theme.values()) {
            if (theme.getKey().equals(savedValue)) {
                return theme;
            }
        }
        return Theme.ONE;
    }
}
