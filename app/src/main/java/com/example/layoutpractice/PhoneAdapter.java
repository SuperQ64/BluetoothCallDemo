package com.example.layoutpractice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends BaseAdapter {
    private final String TAG = "PHONE_ADAPTER";
    private LayoutInflater inflater;
    private int layoutID;
    private String[] nameList;
    private Bitmap[] stateList;

    static class ViewHolder {
        TextView name;
        ImageView state;
    }
    public PhoneAdapter(Context context, int layoutID, Phone[] phones){
        inflater = LayoutInflater.from(context);
        this.layoutID = layoutID;
        nameList = new String[phones.length];
        stateList = new Bitmap[phones.length];

        for(int i = 0;i < phones.length;i++){
            nameList[i] = phones[i].getNAME();
            if(phones[i].getState() == PhoneState.ONLINE){
                stateList[i] = BitmapFactory.decodeResource(context.getResources(),R.drawable.online32);
            } else {
                stateList[i] = BitmapFactory.decodeResource(context.getResources(),R.drawable.clear32px);
            }
            Log.d(TAG,nameList[i]);
        }
    }

    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;


        if(view == null) {
            view = inflater.inflate(layoutID,null);
            holder = new ViewHolder();
            holder.state = view.findViewById(R.id.img_state);
            holder.name = view.findViewById(R.id.name);
            Log.d(TAG,String.valueOf(holder.name));
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        holder.state.setImageBitmap(stateList[i]);
        holder.name.setText(nameList[i]);
        return view;
    }
}
