package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    View buttonAdd;
    View buttonRemove;
    View buttonConfirm;
    EditText inputField;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
        buttonAdd = findViewById(R.id.add_button);
        buttonRemove = findViewById(R.id.remove_button);
        buttonConfirm = findViewById(R.id.confirm_button);
        inputField = findViewById(R.id.city_input);
        buttonConfirm.setVisibility(View.GONE);
        inputField.setVisibility(View.GONE);
        String[] cities = {"Edmonton", "Vancouver", "Edmonton 2"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        //Taken from: https://stackoverflow.com/a/40929808
        //Authored by viper
        //Taken by Chloe Watts on 2025-01-17
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selected = (String) cityList.getItemAtPosition(position);
            }
        });
    }

    public void addCity(View v){
        buttonConfirm.setVisibility(View.VISIBLE);
        inputField.setVisibility(View.VISIBLE);
    }
    public void removeCity(View v){
        dataList.remove(selected);
        selected = null;
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
    }
    public void confirmCity(View v){
        dataList.add(inputField.getText().toString());
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        buttonConfirm.setVisibility(View.GONE);
        inputField.setVisibility(View.GONE);
    }
}