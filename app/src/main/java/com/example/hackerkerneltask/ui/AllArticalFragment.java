package com.example.hackerkerneltask.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackerkerneltask.Adapter.AllArticalAdapter;
import com.example.hackerkerneltask.R;
import com.example.hackerkerneltask.model.AllArtical;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllArticalFragment extends Fragment {

    private RecyclerView aartical_recycler;
    private  ArrayList<AllArtical> list = new ArrayList<>();


    public AllArticalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_artical, container, false);

        aartical_recycler = view.findViewById(R.id.aartical_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        aartical_recycler.setLayoutManager(layoutManager);


        list.add(new AllArtical("","5 Minute of Daily Yoga","msdjbbsdj"));
        list.add(new AllArtical("","5 Minute of Daily Yoga","msdjbbsdj"));
        list.add(new AllArtical("","5 Minute of Daily Yoga","msdjbbsdj"));
        list.add(new AllArtical("","5 Minute of Daily Yoga","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));
        list.add(new AllArtical("","Much up your way","msdjbbsdj"));


        AllArticalAdapter adapter = new AllArticalAdapter(getActivity(),list);
        aartical_recycler.setAdapter(adapter);

        return  view;
    }

}
