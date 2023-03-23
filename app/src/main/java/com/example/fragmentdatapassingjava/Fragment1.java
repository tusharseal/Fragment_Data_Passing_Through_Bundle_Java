package com.example.fragmentdatapassingjava;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentdatapassingjava.databinding.Fragment1Binding;

public class Fragment1 extends Fragment implements IOnBackPressed {

    Fragment1Binding binding;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = Fragment1Binding.inflate(inflater, container, false);

        binding.passData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Data1 = binding.data1.getText().toString();
                String Data2 = binding.data2.getText().toString();
                String Data3 = binding.data3.getText().toString();

                bundle = new Bundle();
                bundle.putString("data1", Data1);
                bundle.putString("data2", Data2);
                bundle.putString("data3", Data3);

                Fragment fragment = new Fragment2();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                fragmentTransaction.replace(R.id.frameLayout, fragment)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });

        return binding.getRoot();
    }

    @Override
    public boolean onBackPressed() {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        return false;
    }

}