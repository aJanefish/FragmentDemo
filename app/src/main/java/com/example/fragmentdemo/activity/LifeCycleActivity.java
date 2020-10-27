package com.example.fragmentdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.fragment.AnotherRightFragment;
import com.example.fragmentdemo.fragment.RightFragment;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("zhangyu1027", "LifeCycleActivity onCreate" + this.hashCode());

    }

    Fragment mFragment = null;

    private void transactionFragment(Fragment fragment) {
        mFragment = fragment;
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //向容器添加或者替换Fragment
        beginTransaction.replace(R.id.activity_life_cycle_fl, fragment);
        //beginTransaction.add(R.id.activity_life_cycle_fl, fragment);
        //加入返回栈
        //beginTransaction.addToBackStack(null);
        //提交事务
        beginTransaction.commit();
    }

    boolean flag = false;

    public void lifeCycleTest1(View view) {
        if (flag) {
            AnotherRightFragment anotherRightFragment = new AnotherRightFragment();
            Bundle bundle = new Bundle();
            long now = System.currentTimeMillis();
            //Log.d("zhangyu1027", "interactionActivityTest start AnotherRightFragment now:" + now);
            anotherRightFragment.setArguments(bundle);
            transactionFragment(anotherRightFragment);
        } else {
            RightFragment rightFragment = new RightFragment();
            Bundle bundle = new Bundle();
            long now = System.currentTimeMillis();
            //Log.d("zhangyu1027", "interactionActivityTest start RightFragment now:" + now);
            rightFragment.setArguments(bundle);
            transactionFragment(rightFragment);
        }
        flag = !flag;
    }

    public void lifeCycleTest2(View view) {
        if (flag) {
            hide(mFragment);
        } else {
            show(mFragment);
        }
        flag = !flag;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zhangyu1027", "LifeCycleActivity onDestroy" + this.hashCode());
    }


    private void hide(Fragment fragment) {
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.hide(fragment);
        //提交事务
        beginTransaction.commit();
    }

    private void show(Fragment fragment) {
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.show(fragment);
        //提交事务
        beginTransaction.commit();
    }

    private void replaceFragmentAndAddBack(Fragment fragment) {
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //向容器添加或者替换Fragment
        beginTransaction.replace(R.id.activity_life_cycle_fl, fragment);
        //加入返回栈
        beginTransaction.addToBackStack(null);
        //提交事务
        beginTransaction.commit();
    }
}