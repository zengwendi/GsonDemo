package com.goat.gsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView json_string = (TextView) findViewById(R.id.json_string);
        TextView json_obj = (TextView) findViewById(R.id.json_obj);
        Gson gson = new GsonBuilder().registerTypeAdapter(List.class,new ListDefault0Adapter()).create();
        User user = new User("张三", 21, "");
        String jsonObject = gson.toJson(user);
        json_string.setText(jsonObject);
        UserList list = gson.fromJson(jsonObject, UserList.class);
        json_obj.setText(list.toString());
    }
}
