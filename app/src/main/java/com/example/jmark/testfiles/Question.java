package com.example.jmark.testfiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jmark.R;

public class Question extends Activity {

    private String q_id;
    private EditText ET_id;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ET_id = findViewById(R.id.editText);


    }

    public void findQuestion(View view){
        q_id = ET_id.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask(this);
        String method = "retrieve";
        backgroundTask.execute(method, q_id);
    }
}
