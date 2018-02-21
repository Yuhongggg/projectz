package com.projectz.appz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.projectz.appz.R;
import com.projectz.appz.common.KeyConstants;

import java.util.Map;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchPreferences();
    }

    private void fetchPreferences() {
        SharedPreferences preferences =
                getSharedPreferences(
                        KeyConstants.SHARED_PREFERENCE_FILE_KEY,
                        Context.MODE_PRIVATE);
        StringBuilder outputBuilder = new StringBuilder();
        Map<String, ?> preferencesMapping = preferences.getAll();
        for (String key : preferences.getAll().keySet()) {
            outputBuilder.append(key).append(": ").append(preferencesMapping.get(key)).append("\n");
        }
        TextView preferencesView = (TextView) findViewById(R.id.preference_view);
        preferencesView.setText(outputBuilder.toString());
    }

    public void savePreference(View view) {
        String key = ((TextView) findViewById(R.id.preference_key)).getText().toString();
        String value = ((TextView) findViewById(R.id.preference_value)).getText().toString();
        SharedPreferences preferences =
                getSharedPreferences(
                        KeyConstants.SHARED_PREFERENCE_FILE_KEY,
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
        fetchPreferences();
    }

    public void deletePreference(View view) {
        String key = ((TextView) findViewById(R.id.preference_key)).getText().toString();
        SharedPreferences preferences =
                getSharedPreferences(
                        KeyConstants.SHARED_PREFERENCE_FILE_KEY,
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
        fetchPreferences();
    }

    public void refresh(View view) {
        fetchPreferences();
    }
}
