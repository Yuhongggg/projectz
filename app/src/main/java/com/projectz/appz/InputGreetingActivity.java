package com.projectz.appz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.projectz.appz.common.KeyConstants;

public class InputGreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_greeting);
    }

    /** Called when the user taps the Send button */
    public void sendGreeting(View view) {
        Intent intent = new Intent(this, GreetingActivity.class);
        EditText editText = (EditText) findViewById(R.id.text_input);
        String message = editText.getText().toString();
        intent.putExtra(KeyConstants.GREETING_STRING, message);
        startActivity(intent);
    }
}
