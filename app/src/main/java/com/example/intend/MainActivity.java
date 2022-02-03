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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] citys = { "Москва" };
    String selected_item="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        String city = Paper.book().read("city") != null ? Paper.book().read("city"):"";
        if (!city.equals("")){
            start_main_screen_activity();
            finish();
        }
        else {
            Button b = findViewById(R.id.button);
            b.setOnClickListener(this);

            Spinner spinner = findViewById(R.id.spinner);
            // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, citys);
            // Определяем разметку для использования при выборе элемента
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Применяем адаптер к элементу spinner
            spinner.setAdapter(adapter);

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
            spinner.setAdapter(adapter);

        }
    }

    public void start_main_screen_activity(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("selected", (String) Paper.book().read("city"));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Paper.book().write("city", selected_item);
        start_main_screen_activity();
    }
}