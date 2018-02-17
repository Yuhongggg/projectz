package com.projectz.appz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.projectz.appz.common.KeyConstants;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Intent intent = getIntent();
        String message = "Coldly welcome: " + intent.getStringExtra(KeyConstants.GREETING_STRING);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.greeting_text);
        textView.setText(message);
    }
}
