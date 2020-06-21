package com.example.project7_zukron_alviandy_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project7_zukron_alviandy_r.adapter.FoodAdapter;
import com.example.project7_zukron_alviandy_r.model.Food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Food> foodList;
    private final String URL_LIST_FOOD = "http://10.0.2.2/ServerECommerce/ListFood.php";
    private FoodAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_restaurant);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        foodList = new ArrayList<>();
        foodData();
    }

    private void foodData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LIST_FOOD, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject food = array.getJSONObject(i);
                        foodList.add(new Food(
                                food.getInt("id"),
                                food.getString("nama"),
                                food.getString("keterangan"),
                                food.getDouble("harga"),
                                food.getDouble("promo"),
                                food.getString("gambar")
                        ));
                    }

                    adapter = new FoodAdapter(MainActivity.this, foodList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
//        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }
}
