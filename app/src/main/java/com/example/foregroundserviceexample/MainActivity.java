package com.example.foregroundserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNotification = findViewById(R.id.etNotification);
    }

    public void onStartService(View v){
        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("EXTRA_TEXT",etNotification.getText().toString());
        //startService(intent);  //if notification channel is not created through ExampleService class, system will destroy the service in 1 min.
        startForegroundService(intent); //if notification channel is not created through ExampleService class, system will destroy the service in 5 seconds.
    }

    public void onStopService(View v){
        Intent intent = new Intent(this, ExampleService.class);
        stopService(intent);
        etNotification.setText("");
    }
}
