package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.view.Gravity;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> questionsList, optionsList;
    ArrayList<String> selectedList = new ArrayList<String>(10);
    TextView textView;
    RadioGroup rGroup;
    RadioButton choice, opOne, opTwo, opThree;
    int index = 0;

    void setVal()
    {
        textView.setText(questionsList.get(index));
        opOne.setText(optionsList.get(index * 3));
        opTwo.setText(optionsList.get((index * 3) + 1));
        opThree.setText(optionsList.get((index * 3) + 2));
    }

    void memorize()
    {
        if(rGroup.getCheckedRadioButtonId() == -1)
        {
            selectedList.set(index, "Deselected");
        }
        else
        {
            int chosenID = rGroup.getCheckedRadioButtonId();
            choice = (RadioButton) findViewById(chosenID);
            selectedList.set(index, choice.getText().toString());
        }
    }

    public void goForward(View view)
    {
        if(index == 9)
        {
            showToast("You are at Final Question!");
        }
        else
        {
            memorize();
            index++;
            setVal();
        }
    }

    void showToast(String msg)
    {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void submit(View view)
    {
        memorize();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("Answers Chosen: ", selectedList);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        rGroup = findViewById(R.id.rGroup);
        opOne = findViewById(R.id.opOne);
        opTwo = findViewById(R.id.opTwo);
        opThree = findViewById(R.id.opThree);

        String[] questions = getResources().getStringArray(R.array.questions);
        questionsList = new ArrayList<String>(asList(questions));
        String[] choices = getResources().getStringArray(R.array.choices);
        optionsList = new ArrayList<String>(asList(choices));
        setVal();
    }
}