package com.example.jmark.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.jmark.R;

import java.util.ArrayList;

public class QuestionTwoActivity extends Activity {
    private String q_id;
    private ArrayList<String> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        q_id = "2";
        setContentView(R.layout.activity_let_me_choose_question_two);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        String method = "retrieve";
        backgroundTask.execute(method, q_id);
        mylist = new ArrayList<>();
    }
    public void buttonOne(View view){
        mylist.add("1");
        Intent intent = new Intent(this,QuestionThreeActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonTwo(View view){
        mylist.add("2");
        Intent intent = new Intent(this,QuestionThreeActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonThree(View view){
        mylist.add("3");
        Intent intent = new Intent(this,QuestionThreeActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonFour(View view){
        mylist.add("4");
        Intent intent = new Intent(this,QuestionThreeActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonFive(View view){
        mylist.add("5");
        Intent intent = new Intent(this,QuestionThreeActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }

}
