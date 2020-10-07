package com.example.fragmentdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentdemo.R;

/**
 * 通过xml注册使用Fragment
 */
public class XmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
    }
}