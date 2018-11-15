package com.example.jmark.dataobject;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jmark.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder>{
    private List<Restaurant> list = new ArrayList<>();

    public RecyclerAdapter(List<Restaurant> list)
    {
        this.list = list;
    }
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_view,parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        holder.id.setText(Integer.toString(list.get(position).getId()));
        holder.name.setText(list.get(position).getName());
        holder.address.setText(list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {

        TextView id, name, address;
        public MyViewholder(View restaurantView) {
            super(restaurantView);

            id = (TextView) restaurantView.findViewById(R.id.id);
            name = (TextView) restaurantView.findViewById(R.id.name);
            address = (TextView) restaurantView.findViewById(R.id.address);
        }
    }
}
