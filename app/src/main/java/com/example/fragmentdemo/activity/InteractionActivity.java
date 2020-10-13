package com.example.fragmentdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.fragment.AnotherRightFragment;
import com.example.fragmentdemo.fragment.RightFragment;

import org.w3c.dom.Text;

//测试Activity->Fragment |  Fragment ->  Activity| Fragment -> Fragment 之间的交互
public class InteractionActivity extends AppCompatActivity implements RightFragment.OnMsgChangeListener {


    private TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);
        des = findViewById(R.id.activity_interaction_des);
    }

    private void replaceFragment(Fragment fragment) {
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //向容器添加或者替换Fragment
        beginTransaction.replace(R.id.activity_interaction_fl, fragment);
        //加入返回栈
        beginTransaction.addToBackStack(null);
        //提交事务
        beginTransaction.commit();
    }

    boolean flag = false;

    public void interactionActivityTest(View view) {
        if (flag) {
            AnotherRightFragment anotherRightFragment = new AnotherRightFragment();
            Bundle bundle = new Bundle();
            long now = System.currentTimeMillis();
            Log.d("zhangyu20201012", "interactionActivityTest start AnotherRightFragment now:" + now);
            bundle.putString("testKey", "" + now);
            anotherRightFragment.setArguments(bundle);
            replaceFragment(anotherRightFragment);
        } else {
            RightFragment rightFragment = new RightFragment();
            rightFragment.setMsgChangeListener(this);
            Bundle bundle = new Bundle();
            long now = System.currentTimeMillis();
            Log.d("zhangyu20201012", "interactionActivityTest start RightFragment now:" + now);
            bundle.putString("testKey", "" + now);
            rightFragment.setArguments(bundle);
            replaceFragment(rightFragment);
        }
        flag = !flag;
    }

    public void testDes(String msg) {
        des.setText(msg);
    }

    @Override
    public void msgChange(String msg) {
        des.setText(msg);
    }
}