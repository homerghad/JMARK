package com.example.jmark.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmark.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuestionThreeActivity extends Activity {
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final String URL = "https://foodfindconsole.herokuapp.com/";
    private static final String QuestionURL = "question_script.php";
    private static final String AnswerURL = "answer_script.php";
    JSONParser jsonParser = new JSONParser();
    JSONArrayParser jsonArrayParser = new JSONArrayParser();

    private String q_id;
    private ArrayList<String> myButtonList;
    private ArrayList<String> myButtonNumberList;
    private TextView questionText;

    private Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        q_id = "2";
        setContentView(R.layout.activity_let_me_choose_question_three);

        questionText = (TextView) findViewById(R.id.textView5);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        getQuestion gq = new getQuestion();
        gq.execute();

        getAnswers ga = new getAnswers();
        ga.execute();

        myButtonList = new ArrayList<>();
        myButtonNumberList = new ArrayList<>();

    }

    public void buttonOne(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("answer2", myButtonNumberList.get(0));
        editor.apply();
        Intent intent = new Intent(this,QuestionFiveActivity.class);
        startActivity(intent);
    }
    public void buttonTwo(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("answer2", myButtonNumberList.get(1));
        editor.apply();
        Intent intent = new Intent(this,QuestionFiveActivity.class);
        startActivity(intent);
    }
    public void buttonThree(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("answer2", myButtonNumberList.get(2));
        editor.apply();
        Intent intent = new Intent(this,QuestionFiveActivity.class);
        startActivity(intent);
    }
    public void buttonFour(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("answer2", myButtonNumberList.get(3));
        editor.apply();
        Intent intent = new Intent(this,QuestionFiveActivity.class);
        startActivity(intent);
    }

    private class getQuestion extends AsyncTask<String, String, JSONObject> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override

        protected JSONObject doInBackground(String... args) {
            String passedURL = URL + QuestionURL;

            ArrayList params = new ArrayList();
            String questionID = "21";
            params.add(new BasicNameValuePair("Question_ID", questionID));
            JSONObject json = jsonParser.makeHttpRequest(passedURL, "POST", params);
            return json;
        }

        protected void onPostExecute(JSONObject result) {
            try {
                if (result != null) {
                    Log.e("output", result.getString("Question_Text"));

                    questionText.setText(result.getString("Question_Text"));

                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class getAnswers extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override

        protected String doInBackground(String... args) {

            String passedURL = URL + AnswerURL;

            ArrayList params = new ArrayList();

            String questionID = "21";
            params.add(new BasicNameValuePair("Question_ID", questionID));
            String json = jsonArrayParser.makeHttpRequest(passedURL, "POST", params);
            return json;
        }

        protected void onPostExecute(String result) {
            try {
                if (result != null) {
                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = new JSONObject();

                    for(int i = 0; i < ja.length(); i++){
                        jo = ja.getJSONObject(i);
                        myButtonList.add(jo.getString("Answer_Text"));
                        myButtonNumberList.add(jo.getString("Answer_ID"));
                        Log.e("answers", myButtonList.get(i));
                    }

                    b1.setText(myButtonList.get(0));
                    b2.setText(myButtonList.get(1));
                    b3.setText(myButtonList.get(2));
                    b4.setText(myButtonList.get(3));

                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
