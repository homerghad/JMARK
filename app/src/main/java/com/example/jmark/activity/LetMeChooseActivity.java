package com.example.jmark.activity;

import android.content.Intent;
import android.databinding.DataBinderMapperImpl;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jmark.R;
import com.example.jmark.databinding.ActivityLetMeChooseBinding;
import com.example.jmark.dataobject.Answer;
import com.example.jmark.dataobject.Question;

import java.util.ArrayList;
import java.util.List;

public class LetMeChooseActivity extends AppCompatActivity {

    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLetMeChooseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_let_me_choose);


        question = new Question();
        question.setText("How much are you willing to spend?");

        binding.setQuestion(question);

//        setContentView(R.layout.activity_let_me_choose);
    }

    public void goToChosenRestaurantActivity(View view) {


        Intent intent = new Intent(this, ChooseForMeActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
