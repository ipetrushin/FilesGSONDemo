package com.example.filesgsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources r = getResources();

        // чтение файла построчно
        InputStream cities_stream = r.openRawResource(R.raw.cities);
        Scanner sc = new Scanner(cities_stream);
        while (sc.hasNextLine()){
            Log.d("mytag", sc.nextLine());
        }

        // обработка файла в формате JSON
        InputStream stream = r.openRawResource(R.raw.persons);
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        Person[] people = gson.fromJson(reader, Person[].class);
        for (Person p : people) {
            Log.d("mytag", p.toString());
        }
    }
}
