package com.example.shadh.loginreg;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        {
            //setContentView(R.layout.grid_layout);
            WebView webview = new WebView(getContext());




            GridView gridview = view.findViewById(R.id.grid_view);
            gridview.setAdapter(new ImageAdapter(getActivity()));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
              //      Toast.makeText(getContext(), "CLICKED" + position,
                    //        Toast.LENGTH_SHORT).show();

                    Uri uri = Uri.parse("https://www.nike.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
            });

        }
        return view;
    }

}