package com.example.intend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import io.paperdb.Paper;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    String[] citys = { "Москва", "Санкт-Петербург" };
    String selected_item="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, citys);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        int index = 0;

        for (int i = 0; i < citys.length; i++) {
            if (citys[i].equals(Paper.book().read("city"))) {
                index = i;
            }
        }
        spinner.setAdapter(adapter);
        spinner.setSelection(index);

        Button save_button = (Button) findViewById(R.id.save);
        save_button.setOnClickListener(this);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                selected_item = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

    }
    @Override
    public void onClick(View view) {
        Paper.book().write("city", selected_item);
        Intent intent = new Intent(SettingsActivity.this, WelcomeActivity.class);
        intent.putExtra("selected", selected_item);
        startActivity(intent);
        finish();

    }
}