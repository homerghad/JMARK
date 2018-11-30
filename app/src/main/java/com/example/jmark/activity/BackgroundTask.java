package com.example.jmark.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    ArrayList<String> answers_id;
    public BackgroundTask(Context ctx){
        this.ctx = ctx;
        answers_id = new ArrayList<>();
    }
    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Question Information");
    }
    @Override
    protected String doInBackground(String... params){
        String question_url = "https://shielded-beach-88931.herokuapp.com/question_script.php";
        String tag_url = "http://10.0.2.2/saankakain/tag_script.php";
        String answer_url = "http://10.0.2.2/saankakain/answer_script.php";
        String method = params[0];
        if(method.equals("retrieve")){
            String q_id = params[1];
            try {
                URL a_url = new URL(answer_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) a_url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(os,"UTF-8")));
                String data = URLEncoder.encode("Question_ID","UTF-8") +"="+URLEncoder.encode(q_id,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String response = "";
                String line;
                while((line = bufferedReader.readLine())!=null){
                    answers_id.add(line);
                }
                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result){

    }
}
