package com.example.customtoolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.customtoolbar.component.CommonToolbar;

public class MainActivity extends AppCompatActivity {

    private CommonToolbar commonToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commonToolbar = findViewById(R.id.common_tool_bar);

        commonToolbar.setTitle("Title 정의");

        commonToolbar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
