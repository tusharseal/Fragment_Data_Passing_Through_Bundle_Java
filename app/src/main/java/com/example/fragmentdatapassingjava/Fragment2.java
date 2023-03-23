package com.example.fragmentdatapassingjava;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentdatapassingjava.databinding.Fragment2Binding;


public class Fragment2 extends Fragment implements IOnBackPressed1 {

    Fragment2Binding binding;
    Bundle bundle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = Fragment2Binding.inflate(inflater, container, false);

        bundle = this.getArguments();

        if (bundle != null) {
            String data1 = bundle.getString("data1");
            String data2 = bundle.getString("data2");
            String data3 = bundle.getString("data3");

            binding.data1txtview.setText("Data 1:" + data1);
            binding.data2txtview.setText("Data 2:" + data2);
            binding.data3txtview.setText("Data 3:" + data3);
        } else {
            binding.data1txtview.setText("Data 1:");
            binding.data2txtview.setText("Data 2:");
            binding.data3txtview.setText("Data 3:");
        }


        binding.activity1btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        return binding.getRoot();
    }


    @Override
    public boolean onBackPressed1() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        return false;
    }
}