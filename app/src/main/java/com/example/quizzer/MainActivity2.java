package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import android.widget.TextView;
import static java.util.Arrays.asList;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    ArrayList<String> answerList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        int score = 0;

        ArrayList<String> chosen =  (ArrayList<String>)getIntent().getSerializableExtra("Selected_Answers");
        String[] corrects = getResources().getStringArray(R.array.corrects);
        answerList = new ArrayList<String>(asList(corrects));

        for (int i = 0; i < 10; i++)
        {
            if(answerList.get(i).equals(chosen.get(i)))
            {
                score++;
            }
        }

        textView.setText("VOILA! Your score is: " + score);
    }
}