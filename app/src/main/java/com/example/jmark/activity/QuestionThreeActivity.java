package com.example.jmark.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jmark.R;

import java.util.ArrayList;

public class QuestionThreeActivity extends Activity {
    private String q_id;
    ArrayList<String> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        q_id = "2";
        setContentView(R.layout.activity_let_me_choose_question_three);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        String method = "retrieve";
        backgroundTask.execute(method, q_id);
        mylist = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
    }
    public void buttonOne(View view){
        mylist.add("6");
        Intent intent = new Intent(this,QuestionFiveActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonTwo(View view){
        mylist.add("7");
        Intent intent = new Intent(this,QuestionFiveActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonThree(View view){
        mylist.add("8");
        Intent intent = new Intent(this,QuestionFiveActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonFour(View view){
        mylist.add("9");
        Intent intent = new Intent(this,QuestionFiveActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }

}
