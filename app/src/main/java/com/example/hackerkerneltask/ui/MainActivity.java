package com.example.hackerkerneltask.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackerkerneltask.Network.Constant;
import com.example.hackerkerneltask.Network.PostRequest;
import com.example.hackerkerneltask.Network.RetrofitClint;
import com.example.hackerkerneltask.R;
import com.example.hackerkerneltask.model.LoginRequest;
import com.fxn.stash.Stash;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i("sdjkcbs", "onStart: "+Stash.getString("token"));
//        if(!Stash.getString("token").equals("")){
//            startActivity(new Intent(MainActivity.this,DashBoardActivity.class));
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RetrofitClint.getRetrofit(Constant.BASE_URL)
                        .create(PostRequest.class)
                        .login(new LoginRequest(email.getText().toString(),password.getText().toString()))
                       .enqueue(new Callback<JsonObject>() {
                           @Override
                           public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                               Log.i("mshmcbjsd", "onResponse: "+response);
                               Log.i("mshmcbjsd", "onResponse: "+response.body());

                               if (response.code()==200){
                                   String token = response.body().get("token").toString();
                                   Log.i("mshmcbjsd",""+token);
                                   Stash.put("token",token);
                                   Toast.makeText(MainActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
                               }
                               else {
                                   Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                               }
                           }

                           @Override
                           public void onFailure(Call<JsonObject> call, Throwable t) {

                               Log.i("mdbjdfhj", "onFailure: "+t);
                           }
                       });            }
        });


    }
}
