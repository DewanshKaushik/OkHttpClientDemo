package com.okhttpclientdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getDAtafromVolley();
            }

        }).start();
    }

    private JSONObject getJsonArray() {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject3 = new JSONObject();
        try {
            JSONObject jsonObject1 = new JSONObject();

            jsonObject1.put("fee_id", 74);
            jsonObject1.put("monthly", 100);
            jsonObject1.put("quarterly", 300);
            jsonObject1.put("half_yearly", 600);
            jsonObject1.put("yearly", 1200);
            jsonObject1.put("category_name", "Advanced high");


            jsonArray.put(jsonObject1);

            JSONObject jsonObject2 = new JSONObject();

            jsonObject2.put("fee_id", 85);
            jsonObject2.put("monthly", 100);
            jsonObject2.put("quarterly", 300);
            jsonObject2.put("half_yearly", 600);
            jsonObject2.put("yearly", 1200);
            jsonObject2.put("category_name", "Royal high");


            jsonArray.put(jsonObject2);

            jsonObject3.put("payload", jsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject3;
    }


    private void getDAtafromVolley() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest arrayreq = new JsonObjectRequest(com.android.volley.Request.Method.POST, "http://139.59.32.104/api/saas/data/fees/edit", getJsonArray(),
                new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (response != null) {
                            Log.e("Volley", response.toString());
                            textView.setText(response.toString());
                        }
                    }
                },

                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        ) {

            @Override
            public Map getHeaders() {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImExMTlmMTdhODMyNWM4NDNiY2EwMjBiMWNhMmRiODQ5OGQ5MTY2NTEyN2EyMDY4ZTRkNmQ4ZjAyNTRlNzRkMGYwNDgxYjgzMTJlZGMwNjhiIn0.eyJhdWQiOiI5IiwianRpIjoiYTExOWYxN2E4MzI1Yzg0M2JjYTAyMGIxY2EyZGI4NDk4ZDkxNjY1MTI3YTIwNjhlNGQ2ZDhmMDI1NGU3NGQwZjA0ODFiODMxMmVkYzA2OGIiLCJpYXQiOjE1ODg2NTU0MzEsIm5iZiI6MTU4ODY1NTQzMSwiZXhwIjoxNjIwMTkxNDMxLCJzdWIiOiIxMDUxIiwic2NvcGVzIjpbXX0.Xj0g1jLI2XahBu7n144vqbPtVDkREytrhTwddZkA21lD-R-0DtCPd3KYK7Qc2SNWG7_MhB9y10wD5QVR6QagPKMyD_dlvDsqLvkhWPHCCirqxaur9SaPU-yIPez4cR0oqgxoJxTz7CRHpJSuc__7UKdTIUG0bKFslb4eXrNt7H4auFXvTwZtQNwuWnJZRXeN3wE_qShoOYB4dTs__TdGB8TxJ21Sd2EWs5J2kwuRmNO1Ic6hHccPUH_vm33Y5nzWhG2jkkEvGBcoSjCrmT_9tDXaapoApWooGhSXVT30ZD02eJ199AtpqWF0HrnI3X5zZ38lOKZPHMHfqbdLcJZEM8-dAu-CIIFPsUsDKvPO125tQM7B-xO4JeEEnYPZU5UKPo5VrBb3dYvRPkdYot4OSYcCWwhl6LLbdbb5OCzqVZ_-BjCxpnbiZ-v7eAO33t7Mgzxs08G900HTCXvHzSvL7_6OJwZzEbmjiXYJtlryoFoKNjXFbqKJZ3KniCpyIli_1dKZrpBJ6uJkN2NQEGyxGm5Pm3zrJiuLUXUBw2pNwiAVo6AaWRdVYRM2Fl_EqeMGCNLqQk5CqS1gxzJ-8eMaw2G_Y-t1OEZ4e4L1w7yWZ6d-c7krRDVSvu7teAefDcdqsA9B1nw8jp2_aX-4htHHsjG8xUyh_xGNdDLOksrjx3E");
                return headers;
            }

        };
        requestQueue.add(arrayreq);
    }

}