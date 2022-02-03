package com.example.intend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import io.paperdb.Paper;

public class WelcomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String name = bundle.getString("selected", "");
            System.out.println("ASDF");
            TextView textView = findViewById(R.id.city_name);
            textView.setText(name);
        }


        Button button_main = (Button) findViewById(R.id.main);

        Button button_search = (Button) findViewById(R.id.search);


        Button button_settings = (Button) findViewById(R.id.settings);


        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SettingsActivity.class);
                intent.putExtra("selected", (String) Paper.book().read("city"));
                startActivity(intent);
                finish();
            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = Paper.book().read("city");
        TextView textView = findViewById(R.id.city_name);
        textView.setText(name);
    }
}