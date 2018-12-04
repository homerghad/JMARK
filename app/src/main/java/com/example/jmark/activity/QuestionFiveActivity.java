package com.example.jmark.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jmark.R;

import java.util.ArrayList;

public class QuestionFiveActivity extends Activity {
    private String q_id;
    ArrayList<String> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        q_id = "2";
        setContentView(R.layout.activity_let_me_choose_question_five);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        String method = "retrieve";
        backgroundTask.execute(method, q_id);
        mylist = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
    }
    public void buttonOne(View view){
        mylist.add("15");
        Intent intent = new Intent(this,ChosenRestaurantActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
    public void buttonTwo(View view){
        mylist.add("16");
        Intent intent = new Intent(this,ChosenRestaurantActivity.class).putExtra("mylist",mylist);
        startActivity(intent);
    }
}
