package com.example.shadh.loginreg;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.annotation.Target;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private JSONArray values;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public Button deletebtn;
        public View layout;
        public ImageView listimages;


        public ViewHolder(View v) {
            super(v);
//            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            deletebtn = v.findViewById(R.id.delbtn);
            listimages = v.findViewById(R.id.icon);


        }
    }

    @TargetApi(19)
    public void remove(int position) {
        values.remove(position);
//        listcont.
        MyAdapter.this.notifyDataSetChanged();
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(JSONArray data) {

        values = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.listtext, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        try {
            JSONObject dat = values.getJSONObject(position);

            Integer int1 = dat.getInt("image_id");
            String text = dat.getString("description");
            holder.listimages.setImageResource(int1);
            holder.txtHeader.setText(text);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // final String name = values.get(position);

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //     PopupMenu popup = new PopupMenu(context,v);
                //  popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                // popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                //  @Override
                //     public boolean onMenuItemClick(MenuItem item) {
                remove(position);

                //   return true;
                //   }
                //   });
                //  popup.show();
            }
        });

        //   holder.txtFooter.setText("Model: " + name);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.length();
    }
   /* private Integer[] listcont = {
            R.drawable.shoe1, R.drawable.shoe2,
            R.drawable.shoe3, R.drawable.shoe4,
            R.drawable.shoe5, R.drawable.shoe6,
            R.drawable.shoe7, R.drawable.shoe8,
            R.drawable.shoe9
    };*/
}
