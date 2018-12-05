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



public class ChooseForMeActivity extends AppCompatActivity {
    private static final String URL = "https://shielded-beach-88931.herokuapp.com/";
    private static final String RandomURL = "random_script.php";
    JSONParser jsonParser = new JSONParser();
    JSONArrayParser jsonArrayParser = new JSONArrayParser();

    private TextView titleView;
    private TextView budgetView;
    private TextView addressView;
    private ArrayList<String> myList;
    /*Restaurant restaurant1;
    Restaurant restaurant2;
    Restaurant restaurant3;
    List<Restaurant> restaurantList = new ArrayList<Restaurant>();
    Button button;*/

    /*Map<Integer, String> restaurantNameMap = new HashMap<Integer, String>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_for_me);

        myList = new ArrayList<>();

        getRandom gr = new getRandom();
        gr.execute();
    }

    public void goToChosenRestaurantActivity(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }

    public void restaurantOne(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        TextView txt1 = (TextView) findViewById(R.id.title0);
        String message = txt1.getText().toString();
        intent.putExtra("title", message);
        startActivity(intent);
    }

    public void restaurantTwo(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        TextView txt2 = (TextView) findViewById(R.id.title1);
        String message = txt2.getText().toString();
        intent.putExtra("title", message);
        startActivity(intent);
    }

    public void restaurantThree(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        TextView txt3 = (TextView) findViewById(R.id.title2);
        String message = txt3.getText().toString();
        intent.putExtra("title", message);
        startActivity(intent);
    }

    private class getRandom extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override

        protected String doInBackground(String... args) {

            String passedURL = URL + RandomURL;

            ArrayList params = new ArrayList();


            String json = jsonArrayParser.makeHttpRequest(passedURL, "GET", params);
            System.out.println(json);
            return json;

        }

        protected void onPostExecute(String result) {
            try {
                if (result != null) {
                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = new JSONObject();
                    String test = "";
                    int[] textViews = {R.id.title0,R.id.title1,R.id.title2};
                    int[] budgetViews = {R.id.budget0,R.id.budget1,R.id.budget2};
                    int[] addressViews = {R.id.address0,R.id.address1,R.id.address2};
                    for(int i = 0; i < ja.length(); i++){
                        titleView = (TextView) findViewById(textViews[i]);
                        budgetView = (TextView) findViewById(budgetViews[i]);
                        addressView = (TextView) findViewById(addressViews[i]);
                        jo = ja.getJSONObject(i);
                        titleView.setText(jo.getString("Resto_Name"))  ;
                        budgetView.setText(jo.getString("Budget"))  ;
                        addressView.setText(jo.getString("Address"))  ;

                    }

                    Toast.makeText(ChooseForMeActivity.this, test, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
