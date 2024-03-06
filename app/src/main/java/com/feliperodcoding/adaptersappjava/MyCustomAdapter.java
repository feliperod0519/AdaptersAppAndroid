package com.feliperodcoding.adaptersappjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private String[] items;

    public MyCustomAdapter(Context context,String[] items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return this.items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null){
            //view parameter is a recycled view you can reuse to improve performance
            view = LayoutInflater.from(context).inflate(R.layout.my_list,parent, false);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.text1);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        return view;
    }

    static class ViewHolder{
        //Holds the reference to layout
        TextView textView;
    }
}
