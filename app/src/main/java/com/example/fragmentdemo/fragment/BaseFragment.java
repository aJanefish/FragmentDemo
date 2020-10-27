package com.example.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    String getTAG() {
        return "zhangyu1027-" + this.getClass().getSimpleName();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(getTAG(), "onAttach " + this.hashCode());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getTAG(), "onCreate " + this.hashCode());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(getTAG(), "onCreateView " + this.hashCode());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(getTAG(), "onActivityCreated " + this.hashCode());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getTAG(), "onStart " + this.hashCode());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getTAG(), "onResume " + this.hashCode());
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(getTAG(), "onPause " + this.hashCode());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(getTAG(), "onStop " + this.hashCode());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getTAG(), "onDestroyView " + this.hashCode());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getTAG(), "onDestroy " + this.hashCode());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getTAG(), "onDetach " + this.hashCode());
    }
}
