package com.goat.gsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {
    TextView jsonString;
    TextView jsonObj;
    TextView serializedSingleString;
    TextView serializedMultileString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonString = (TextView) findViewById(R.id.json_string);
        jsonObj = (TextView) findViewById(R.id.json_obj);
        serializedSingleString = (TextView) findViewById(R.id.serializedSingleString);
        serializedMultileString = (TextView) findViewById(R.id.serializedMultileString);
    }

    //创建json
    public void createJson(View view) {
        Gson gson = new GsonBuilder().create();
        Student student = new Student("张三", 21, "88");
        jsonString.setText(gson.toJson(student));

    }

    //解析json
    public void analysisJson(View view) {
        if (TextUtils.isEmpty(jsonString.toString())) {
            return;
        }
        Gson gson = new GsonBuilder().create();
        Student student = gson.fromJson(jsonString.getText().toString(), Student.class);
        jsonObj.setText(student.toString());
    }

    //SerializedName单个使用
    public void serializedNameSingle(View view) {
        String json = "{\"names\":\"张三\",\"age\":21,\"score\":99}";
        Gson gson = new GsonBuilder().create();
        Student student = gson.fromJson(json, Student.class);
        serializedSingleString.setText(student.toString());
    }

    //SerializedName多个使用
    public void serializedNameMulti(View view) {
        String json = "{\"name\":\"张三\",\"age\":21,\"chinese\":88}";
        Gson gson = new GsonBuilder().create();
        Student student = gson.fromJson(json, Student.class);
        serializedMultileString.append(student.toString()+"\n");
        String json1 = "{\"name\":\"张三\",\"age\":21,\"math\":86}";
        Student student1 = gson.fromJson(json1, Student.class);
        serializedMultileString.append(student1.toString()+"\n");
        String json2 = "{\"name\":\"张三\",\"age\":21,\"english\":86}";
        Student student2 = gson.fromJson(json2, Student.class);
        serializedMultileString.append(student2.toString());
    }
}
