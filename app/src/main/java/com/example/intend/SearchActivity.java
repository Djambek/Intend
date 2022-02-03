package com.example.intend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import io.paperdb.Paper;

public class SearchActivity extends AppCompatActivity {
    String[] msk_courts = {"Все суды", "Басманный районный суд","Замоскворецкий районный суд",
            "Мещанский районный суд","Пресненский районный суд","Таганский районный суд",
            "Тверской районный суд","Хамовнический районный", "Головинский районный суд", "Коптевский районный суд","Савёловский районный суд",
            "Тимирязевский районный суд", "Бабушкинский районный суд", "Бутырский районный суд", "Останкинский районный суд",
            "Измайловский районный суд", "Перовский районный суд", "Преображенский районный суд", "Кузьминский районный суд", "Лефортовский районный суд",
            "Люблинский районный суд", "Нагатинский районный суд", "Симоновский районный суд", "Чертановский районный суд", "Гагаринский районный суд", "Зюзинский районный суд",
            "Черёмушкинский районный суд", "Дорогомиловский районный суд", "Кунцевский районный суд", "Никулинский районный суд", "Солнцевский районный суд",
            "Тушинский районный суд", "Хорошёвский районный суд", "Зеленоградский районный суд"};
    String[] spb_courts = {"Тут пока ничего нет"};
    String[] instance = {"Первая", "Апелляционная", "Кассационная", "Надзорная"};
    String court_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        EditText court_case_id = findViewById(R.id.id);
        EditText document_number = findViewById(R.id.doc_number);
        EditText number_court_case = findViewById(R.id.number_court_case);
        EditText court_participants = findViewById(R.id.court_participants);
        ArrayAdapter<String> adapter;
        Spinner spinner = findViewById(R.id.spinner2);
        if (Paper.book().read("city").equals("Москва")) {
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, msk_courts);
        }else{
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spb_courts);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                court_name = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }};
        spinner.setOnItemSelectedListener(itemSelectedListener);
        Spinner spinner_ = findViewById(R.id.spinner3);

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, instance);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AdapterView.OnItemSelectedListener itemSelectedListener_ = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                court_name = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }};
        spinner_.setOnItemSelectedListener(itemSelectedListener_);
        court_case_id.getText();
    }
}