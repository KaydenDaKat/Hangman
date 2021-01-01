package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DuoSetup extends AppCompatActivity {

    private TextView titleTextView;
    private EditText insertEditText;
    private Button startButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo_setup);

        wireWidgets();
        setListeners();
    }

    public void wireWidgets()
    {
        titleTextView = findViewById(R.id.textview_title_duosetup);
        insertEditText = (EditText)findViewById(R.id.edittext_wordinsert_duosetup);
        startButton = findViewById(R.id.button_start_duosetup);
        backButton = findViewById(R.id.button_back_duosetup);
    }

    public void setListeners()
    {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = insertEditText.getText().toString();
                word = spaceRemover(word);

                if (word.equals(""))
                {
                    Toast.makeText(DuoSetup.this,"Insert Word",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DuoSetup.this, word,Toast.LENGTH_SHORT).show();

                    Intent targetIntent = new Intent(DuoSetup.this,Game.class);
                    startActivity(targetIntent);
                    finish();
                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(DuoSetup.this, StartingMenu.class);
                startActivity(targetIntent);
                finish();
            }
        });
    }

    public String spaceRemover(String s)
    {
        String word = s;
        while(word.indexOf(" ") == 0)
        {
            word = word.substring(1);
        }

        return word;
    }
}
