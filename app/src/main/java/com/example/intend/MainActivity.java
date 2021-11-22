package com.example.intend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText  = findViewById(R.id.editTextTextPersonName);
        intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
    }
}