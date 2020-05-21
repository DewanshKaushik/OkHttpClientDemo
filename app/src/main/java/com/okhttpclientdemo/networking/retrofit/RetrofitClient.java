package com.okhttpclientdemo.networking.retrofit;

public class RetrofitClient {

    public class RetrofitClient {
        static ApiService getService(){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            com.okhttpclientdemo.networking.retrofit.RetrofitClient.Builder builder = new com.okhttpclientdemo.networking.retrofit.RetrofitClient.Builder()
                    .baseUrl("http://127.0.0.1:5000/")
                    .addConverterFactory(GsonConverterFactory.create());

            com.okhttpclientdemo.networking.retrofit.RetrofitClient retrofit = builder
                    .client(httpClient.build())
                    .build();

            return retrofit.create(ApiService.class);
        }
    }

    public void getData(){
        RetrofitClient.getService().fetchData(jsonObject).enqueue(new Callback<ResponseClass>() {
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {

            }

            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {

            }
        });
    }


}
