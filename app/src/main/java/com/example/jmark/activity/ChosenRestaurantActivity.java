package com.example.jmark.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmark.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChosenRestaurantActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final String URL = "https://shielded-beach-88931.herokuapp.com/";
    private static final String ChooseURL = "choose_script.php";
    JSONParser jsonParser = new JSONParser();
    JSONArrayParser jsonArrayParser = new JSONArrayParser();

    private String answer1, answer2, answer3;
    private TextView txtID;
    private TextView txtView;
    private ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_restaurant);

        Bundle extras = getIntent().getExtras();
        if (extras != null)  {
            String value = extras.getString("title");
            TextView name = (TextView) findViewById(R.id.textView2);
            name.setText(value)  ;
        }

    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }


}
