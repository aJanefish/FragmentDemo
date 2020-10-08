package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fragmentdemo.activity.FragmentUseActivity;
import com.example.fragmentdemo.activity.InteractionActivity;
import com.example.fragmentdemo.activity.JavaUseFragmentActivity;
import com.example.fragmentdemo.activity.XmlActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void useXml(View view) {
        startActivity(new Intent(this, XmlActivity.class));
    }

    public void javaXml(View view) {
        startActivity(new Intent(this, JavaUseFragmentActivity.class));

    }

    //测试Activity->Fragment |  Fragment ->  Activity| Fragment -> Fragment 之间的交互
    public void interactionTest(View view) {
        startActivity(new Intent(this, InteractionActivity.class));
    }

    public void fragmentUseTest(View view) {
        startActivity(new Intent(this, FragmentUseActivity.class));

    }
}