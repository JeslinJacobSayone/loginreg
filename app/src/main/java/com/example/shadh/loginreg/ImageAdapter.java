package com.example.shadh.loginreg;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ImageAdapter imageAdapter = this;
    public List<Integer> mThumbIds = new ArrayList<>(Arrays.asList
            (R.drawable.shoe1, R.drawable.shoe2,
                    R.drawable.shoe3, R.drawable.shoe4, R.drawable.shoe5,
                    R.drawable.shoe6, R.drawable.shoe7, R.drawable.shoe8, R.drawable.shoe9));

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView, imageicon;
        View var;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            var = inflater.inflate(R.layout.gridicon, null);
            // if it's not recycled, initialize some attributes
           /* imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(245, 245));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
       */
        } else {
            var = convertView;
        }
        int imgid=mThumbIds.get(3);
        imageView = var.findViewById(R.id.gridimage);

        imageicon = var.findViewById(R.id.imagicon);

        imageView.setImageResource(mThumbIds.get(position));

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setPadding(8, 8, 8, 8);


        imageicon.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                PopupMenu menu = new PopupMenu(mContext, v);

                menu.getMenuInflater().inflate(R.menu.menu, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override

                    public boolean onMenuItemClick(MenuItem item) {


                        mThumbIds.remove(position);


                        imageAdapter.notifyDataSetChanged();

                        return false;

                    }

                });

                menu.show();

            }

        });

        return var;

    }
}