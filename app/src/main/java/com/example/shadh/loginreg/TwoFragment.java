package com.example.shadh.loginreg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        JSONArray data=new JSONArray();
        JSONObject data1=new JSONObject();
        try {
            data1.put("image_id",R.drawable.shoe1);
            data1.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data2=new JSONObject();
        try {
            data2.put("image_id",R.drawable.shoe2);
            data2.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data3=new JSONObject();
        try {
            data3.put("image_id",R.drawable.shoe3);
            data3.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data4=new JSONObject();
        try {
            data4.put("image_id",R.drawable.shoe4);
            data4.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject data5=new JSONObject();
        try {
            data5.put("image_id",R.drawable.shoe5);
            data5.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data6=new JSONObject();
        try {
            data6.put("image_id",R.drawable.shoe6);
            data6.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject data7=new JSONObject();
        try {
            data7.put("image_id",R.drawable.shoe7);
            data7.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject data8=new JSONObject();
        try {
            data8.put("image_id",R.drawable.shoe8);
            data8.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data9=new JSONObject();
        try {
            data9.put("image_id",R.drawable.shoe9);
            data9.put("description","NIKE 5944E61");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        data.put(data1);
        data.put(data2);
        data.put(data3);
        data.put(data4);
        data.put(data5);
        data.put(data6);
        data.put(data7);
        data.put(data8);
        data.put(data9);

    /*    List<String> input = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            input.add("Nike165" + i);
        }// define an adapter
        */
      mAdapter = new ListElementAdapter(data,getContext());

        recyclerView.setAdapter(mAdapter);
    return view;
    }
}