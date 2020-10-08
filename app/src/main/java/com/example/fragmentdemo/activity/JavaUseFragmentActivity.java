package com.example.fragmentdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.fragment.AnotherRightFragment;
import com.example.fragmentdemo.fragment.RightFragment;

public class JavaUseFragmentActivity extends AppCompatActivity {

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_use_fragment);

        Button button = findViewById(R.id.left_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    replaceFragment(new AnotherRightFragment());
                } else {
                    replaceFragment(new RightFragment());
                }
                flag = !flag;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //向容器添加或者替换Fragment
        beginTransaction.replace(R.id.activity_java_use_fragment_fl, fragment);
        //加入返回栈
        beginTransaction.addToBackStack(null);
        //提交事务
        beginTransaction.commit();
    }
}