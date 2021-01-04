package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private Button backButton, scoreButton, enterButton;
    private ImageView displayImageView;
    private EditText insertLetterEditText;
    private TextView lettersCorrectTextView, lettersRemainingTextView, lettersUsedTextView;

    private TextView triesLeftTitleTextView, lettersRemainingTitleTextView, lettersUsedTitleTextView;

    private String theWord, underlineSequence;
    private HangmanGame gameClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        wireWidgets();
        setListeners();
        getIntentData();
        setUp();

    }

    public void setUp()
    {
        gameClass = new HangmanGame();
        underlineSequence = gameClass.createInitialUnderlineSequence(theWord);
        lettersCorrectTextView.setText(underlineSequence);
        scoreButton.setText(gameClass.getTries() + "");
        lettersRemainingTextView.setText(gameClass.getLettersRemainingDisplay());
    }

    public void wireWidgets()
    {
        backButton = findViewById(R.id.button_back_game);
        scoreButton = findViewById(R.id.button_score_game);
        enterButton = findViewById(R.id.button_enter_game);

        displayImageView = findViewById(R.id.imageView_display_game);

        insertLetterEditText = findViewById(R.id.editText_insertletter_game);

        lettersCorrectTextView = findViewById(R.id.textView_letterscorrect_game);
        lettersRemainingTextView = findViewById(R.id.textView_lettersremaining_game);
        lettersUsedTextView = findViewById(R.id.textView_lettersused_game);

        triesLeftTitleTextView = findViewById(R.id.textView_triesleft_game);
        lettersRemainingTitleTextView = findViewById(R.id.textView_lettersR_game);
        lettersUsedTitleTextView = findViewById(R.id.textView_lettersU_game);
    }

    public void setListeners()
    {
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(Game.this, DuoSetup.class);
                startActivity(targetIntent);
                finish();
            }
        });
    }

    public void getIntentData()
    {
         theWord = getIntent().getStringExtra("WORD_NAME");
    }
}

