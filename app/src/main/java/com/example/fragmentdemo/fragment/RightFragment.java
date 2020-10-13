package com.example.fragmentdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.activity.InteractionActivity;

public class RightFragment extends Fragment {

    private OnMsgChangeListener msgChangeListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.right_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView des = view.findViewById(R.id.right_fragment_des);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String testKey = bundle.getString("testKey");
            des.setText("來自Activity的信息：" + testKey);
        }

        final FragmentActivity activity = getActivity();
        Log.d("zhangyu20201012", "RightFragment onViewCreated:" + activity);
        Button button = view.findViewById(R.id.right_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (activity instanceof InteractionActivity) {
//                    ((InteractionActivity) activity).testDes("我是来自RightFragment的信息");
//                }
                if (msgChangeListener != null) {
                    msgChangeListener.msgChange("我是来自RightFragment的信息,通过接口");
                }
            }
        });
    }

    /**
     * 内部接口
     */
    public interface OnMsgChangeListener {
        void msgChange(String msg);
    }

    public void setMsgChangeListener(OnMsgChangeListener msgChangeListener) {
        this.msgChangeListener = msgChangeListener;
    }
}
