package com.example.hackerkerneltask.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackerkerneltask.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MembershipFragment extends Fragment {


    public MembershipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_membership, container, false);

        return view;
    }

}
