package com.okhttpclientdemo;

public class App extends Application {
    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());

        // Adding an Network Interceptor for Debugging purpose :
        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);

        // initialize the db once during the app lifecycle
        appDatabase =  Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "person.db"
        ).build();

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // insert into the database
                Person person = new Person();
                person.name= "Idorenyin Obong"
                App.provideDb().getPersonDao().insert(person);
            }
        });
    }

    public static AppDatabase provideDb(){
        return appDatabase;
    }
}
