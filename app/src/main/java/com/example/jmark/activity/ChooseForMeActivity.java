package com.example.jmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jmark.R;
import com.example.jmark.dataobject.MySingleton;
import com.example.jmark.dataobject.RecyclerAdapter;
import com.example.jmark.dataobject.Restaurant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class ChooseForMeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private String server_url = "http://192.168.1.1/SaanKakain/SaanKakain.php";
    private RecyclerAdapter adapter;
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
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        getInformation();

    }

    private void getInformation()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
            @Override
                    public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                List<Restaurant> list = Arrays.asList(gson.fromJson(response, Restaurant[].class));
                adapter = new RecyclerAdapter(list);
                recyclerView.setAdapter(adapter);
            }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(this).addToRequestQue(stringRequest);
    }
    public void goToChosenRestaurantActivity(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
