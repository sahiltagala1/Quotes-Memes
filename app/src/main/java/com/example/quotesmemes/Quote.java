package com.example.quotesmemes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Quote extends AppCompatActivity {

    Random random = new Random();
    TextView textQuote;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        textQuote = findViewById(R.id.textView3);
        btn = findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayQuote();
            }
        });
    }

    public void displayQuote() {
        int randNum = random.nextInt(31) + 1;
        String readQuote = "";

        switch (randNum) {
            case 1:
                readQuote = getString(R.string.q1);
                break;
            case 2:
                readQuote = getString(R.string.q2);
                break;
            case 3:
                readQuote = getString(R.string.q3);
                break;
            case 4:
                readQuote = getString(R.string.q4);
                break;
            case 5:
                readQuote = getString(R.string.q5);
                break;
            case 6:
                readQuote = getString(R.string.q6);
                break;
            case 7:
                readQuote = getString(R.string.q7);
                break;
            case 8:
                readQuote = getString(R.string.q8);
                break;
            case 9:
                readQuote = getString(R.string.q9);
                break;
            case 10:
                readQuote = getString(R.string.q10);
                break;
            case 11:
                readQuote = getString(R.string.q11);
                break;
            case 12:
                readQuote = getString(R.string.q12);
                break;
            case 13:
                readQuote = getString(R.string.q13);
                break;
            case 14:
                readQuote = getString(R.string.q14);
                break;
            case 15:
                readQuote = getString(R.string.q15);
                break;
            case 16:
                readQuote = getString(R.string.q16);
                break;
            case 17:
                readQuote = getString(R.string.q17);
                break;
            case 18:
                readQuote = getString(R.string.q18);
                break;
            case 19:
                readQuote = getString(R.string.q19);
                break;
            case 20:
                readQuote = getString(R.string.q20);
                break;
            case 21:
                readQuote = getString(R.string.q21);
                break;
            case 22:
                readQuote = getString(R.string.q22);
                break;
            case 23:
                readQuote = getString(R.string.q23);
                break;
            case 24:
                readQuote = getString(R.string.q24);
                break;
            case 25:
                readQuote = getString(R.string.q25);
                break;
            case 26:
                readQuote = getString(R.string.q26);
                break;
            case 27:
                readQuote = getString(R.string.q27);
                break;
            case 28:
                readQuote = getString(R.string.q28);
                break;
            case 29:
                readQuote = getString(R.string.q29);
                break;
            case 30:
                readQuote = getString(R.string.q30);
                break;
        }
        textQuote.setText(readQuote);

    }
}
