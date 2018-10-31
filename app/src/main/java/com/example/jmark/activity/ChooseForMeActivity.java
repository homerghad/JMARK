package com.example.jmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jmark.R;

import java.util.HashMap;
import java.util.Map;

public class ChooseForMeActivity extends AppCompatActivity {

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

        /*restaurant1 = new Restaurant(1, true, false, false, "BonChon", "2nd Floor, Regis Center, Katipunan Ave.", new Tag());
        restaurant2 = new Restaurant(2, false, true, false, "Tori Chizu", "2nd Floor, Regis Center, Katipunan Ave.", new Tag());
        restaurant3 = new Restaurant(2, false, false, true, "Samgyupsalamat", "2nd Floor, Regis Center, Katipunan Ave.", new Tag());

        restaurantList.add(restaurant1);
        restaurantList.add(restaurant2);
        restaurantList.add(restaurant3);

        for (Restaurant restaurant : restaurantList) {
            button = new Button(ChooseForMeActivity.this);
            button.setText(restaurant.getName());

        }*/
    }

    public void goToChosenRestaurantActivity(View view) {
        Intent intent = new Intent(this, ChosenRestaurantActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
