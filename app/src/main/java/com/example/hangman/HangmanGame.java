package com.example.hangman;

public class HangmanGame {

    private int tries;
    private String lettersRemaining, lettersRemainingDisplay;

    public HangmanGame()
    {
        tries = 5;
        lettersRemaining = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        createLettersRemainingDisplay();
    }

    public String createInitialUnderlineSequence(String s)
    {
        String word = s;
        int length = word.length();
        String underlineSequence = "";

        for(int i = 0; i < length; i++)
        {
            if (!word.substring(i,i+1).equals(" "))
            {
                underlineSequence += "_ ";
            }
            else
            {
                underlineSequence += "   ";
            }
        }

        underlineSequence = underlineSequence.substring(0,underlineSequence.length()-1);

       return underlineSequence;
    }

    public void createLettersRemainingDisplay()
    {
        for (int i = 0; i < 23; i++)
        {
            lettersRemainingDisplay += lettersRemaining.substring(i,i+1) +" ";
        }

        lettersRemainingDisplay.toUpperCase();
    }

    public int getTries() {
        return tries;
    }

    public String getLettersRemaining() {
        return lettersRemaining;
    }

    public String getLettersRemainingDisplay() {
        return lettersRemainingDisplay;
    }
}
