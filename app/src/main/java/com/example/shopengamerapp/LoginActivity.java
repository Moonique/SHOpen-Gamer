package com.example.shopengamerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends Activity {

    private static final String EXTRA_TEAM_COLOR = "Цвет команды";
    private static final String EXTRA_GAME_DATE = "Дата игры";

    TextInputEditText inputTeamColor;
    TextInputEditText inputGameDate;
    Button buttonLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputGameDate = findViewById(R.id.game_date_input);
        inputTeamColor = findViewById(R.id.team_color_input);
        buttonLogin = findViewById(R.id.login_button);

        buttonLogin.setOnClickListener(v -> login());
    }

    private void login() {
        Intent loginIntent = new Intent(this, MainActivity.class);
        // TODO:Добавить проверки на нулл в текстовое поле
        String teamColor = Objects.requireNonNull(inputTeamColor.getText()).toString();
        String gameDate = Objects.requireNonNull(inputGameDate.getText()).toString();
        loginIntent.putExtra(EXTRA_TEAM_COLOR, teamColor).putExtra(EXTRA_GAME_DATE, gameDate);
        startActivity(loginIntent);
    }
}
