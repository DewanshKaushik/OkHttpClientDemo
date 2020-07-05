package com.okhttpclientdemo.networking;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.okhttpclientdemo.App;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyDemo {

    String url = "";
    Context context;

    private void postRequest(Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest arrayreq = new JsonObjectRequest(com.android.volley.Request.Method.POST, "http://139.59.32.104/api/saas/data/fees/edit", getJsonArray(),
                new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (response != null) {
                            Log.e("Volley", response.toString());
                        }
                    }
                },

                new Response.ErrorListener() {
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
                headers.put("Authorization", "Bearer your token");
                return headers;
            }

        };
        requestQueue.add(arrayreq);
    }


    public void getRequest(Context context) {
        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context);

        final String url = "http://httpbin.org/get?param1=hello";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.e("Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error.Response", error.toString());
                    }
                }
        );

        // add it to the RequestQueue
        requestQueue.add(getRequest);
    }

    public void putRequest() {
        StringRequest putRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.e("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.e("Error.Response", error.toString());
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Alif");
                params.put("domain", "http://itsalif.info");

                return params;
            }

        };

        App.getInstance().requestQueue.add(putRequest);
    }

    public void deleteRequest() {
        url = "http://httpbin.org/delete";
        StringRequest dr = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.e("deleteRequest",response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("deleteRequest",error.toString());
                    }
                }
        );
        App.getInstance().requestQueue.add(dr);
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

    public void getDAtafromVolley(Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest arrayreq = new JsonObjectRequest(com.android.volley.Request.Method.POST, "http://139.59.32.104/api/saas/data/fees/edit", getJsonArray(),
                new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (response != null) {
                            Log.e("Volley", response.toString());
                        }
                    }
                },

                new Response.ErrorListener() {
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
                headers.put("Authorization", "Bearer your token");
                return headers;
            }

        };
        requestQueue.add(arrayreq);
    }

}
