package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingMenu extends AppCompatActivity {

    private TextView titleTextView;
    private Button singlePlayerButton, duoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_menu);

        wireWidgets();

        setListeners();
    }

    public void wireWidgets()
    {
        titleTextView = findViewById(R.id.textView_title_startmenu);
        singlePlayerButton = findViewById(R.id.button_singleplayer_startmenu);
        duoButton = findViewById(R.id.button_duo_startmenu);

    }

    public void setListeners()
    {
        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(StartingMenu.this, SinglePlayerSetup.class);
                startActivity(targetIntent);
                finish();
            }
        });

        duoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(StartingMenu.this, DuoSetup.class);
                startActivity(targetIntent);
                finish();
            }
        });
    }

}
